/* 
 * Copyright (C) 2015 José Sousa & Nuno Carvalho
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package Server.GameNetwork;

import Game.User;
import Net.CCPacket;
import Net.ExcessBytesException;
import Net.PacketTooSmallException;
import Server.EasyLogger;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author José
 */
public class ServerPool implements Runnable {

    //easy logger
    private final PrintWriter logger;
    //resto dos servidores na nossa game network
    private final LinkedBlockingQueue<Socket> servers;
    //socket tcp que esta à escuta de ligações dos outros servers
    private final ServerSocket serversocket;
    //users
    private final Map<String, User> users;
    //executor para as threads de conexao aos servers
    private final Executor ex;

    public ServerPool(EasyLogger logger, Map<String, User> users) throws IOException {
        this.logger = logger;
        this.servers = new LinkedBlockingQueue<>();
        this.serversocket = new ServerSocket(4321);
        this.users = users;
        this.ex = Executors.newCachedThreadPool();
    }

    public ServerPool(EasyLogger logger, Socket socket, Map<String, User> users) throws IOException, PacketTooSmallException {
        this.logger = logger;
        CCPacket ccp = new CCPacket(0, 0, 0, 14);
        byte array[] = new byte[50000];
        //enviar pacote vazio para sinalizar
        socket.getOutputStream().write(ccp.toBytes());
        //obter resposta
        socket.getInputStream().read(array);
        ccp = new CCPacket(array, socket.getRemoteSocketAddress());
        this.logger.println("Ligado ao servidor master!");
        this.serversocket = new ServerSocket(4321);
        this.servers = new LinkedBlockingQueue<>();
        this.servers.add(socket);
        this.users = users;
        this.ex = Executors.newCachedThreadPool();
        ex.execute(new ServerHandler(logger, socket, users, servers));
    }

    private synchronized void broadcastNewServer(Socket socket) {
        try {
            CCPacket ccp = new CCPacket(0, 0, 0, 14);
            ccp.addCampo(30, socket.getInetAddress().getAddress());
            ccp.addCampo(31, BigInteger.valueOf(socket.getPort()).toByteArray());
            for (Socket siblings : this.servers) {
                this.logger.format("Novo servidor enviado para %s", siblings.getInetAddress());
                try {
                    siblings.getOutputStream().write(ccp.toBytes());
                    siblings.getOutputStream().flush();
                } catch (IOException ex) {
                    this.logger.println("Erro ao enviar user" + ex.getMessage());
                    //remover socket com erros
                    this.servers.remove(siblings);
                }
            }
        } catch (ExcessBytesException ex) {
            this.logger.println("Packet 2 big!! at broadcastNewServer");
        }
    }

    public synchronized void broadcastNewUser(User u, int score) {
        try {
            CCPacket ccp = new CCPacket(0, 0, 0, 15);
            ccp.addCampo(1, u.getName().getBytes());
            ccp.addCampo(2, u.getNick().getBytes());
            ccp.addCampo(20, BigInteger.valueOf(u.getScoreGlobal()).toByteArray());
            for (Socket siblings : this.servers) {
                this.logger.format("Novo user enviado para %s e respetiva pontuação a adicionar\n", siblings.getInetAddress());
                try {
                    siblings.getOutputStream().write(ccp.toBytes());
                    siblings.getOutputStream().flush();
                } catch (IOException ex) {
                    this.logger.println("Erro ao enviar user" + ex.getMessage());
                    //remover socket com erros
                    this.servers.remove(siblings);
                }
            }
        } catch (ExcessBytesException ex) {
            this.logger.println("Packet 2 big!! at broadcastNewServer");
        }
    }

    public synchronized void broadcastAllUsers(Socket s) {
        try {
            for (User u : this.users.values()) {
                CCPacket ccp = new CCPacket(0, 0, 0, 15);
                ccp.addCampo(1, u.getName().getBytes());
                ccp.addCampo(2, u.getNick().getBytes());
                ccp.addCampo(20, BigInteger.valueOf(u.getScoreGlobal()).toByteArray());
                this.logger.format("User enviado para %s\n", s.getInetAddress());
                try {
                    s.getOutputStream().write(ccp.toBytes());
                    s.getOutputStream().flush();
                } catch (IOException ex) {
                    this.logger.println("Erro ao enviar user" + ex.getMessage());
                    //remover socket com erros
                    this.servers.remove(s);
                }
            }
        } catch (ExcessBytesException ex) {
            this.logger.println("Packet 2 big!! at broadcastNewServer");
        }
    }

    @Override
    public void run() {
        while (true) {
            try {
                CCPacket ccp;
                byte array[] = new byte[50000];
                Socket siblingServer = serversocket.accept();
                siblingServer.getInputStream().read(array);
                ccp = new CCPacket(array, siblingServer.getRemoteSocketAddress());
                this.logger.format("Novo servidor conectado! %s\n", ccp.getSender());
                ccp = new CCPacket(0, 0, 0, 14);
                siblingServer.getOutputStream().write(ccp.toBytes());
                siblingServer.getOutputStream().flush();
                broadcastNewServer(siblingServer);
                //enviar utilizadores já existentes para este novo servidor
                broadcastAllUsers(siblingServer);
                this.servers.add(siblingServer);
                this.logger.println("Adição de servidor concluída");
                ex.execute(new ServerHandler(logger, siblingServer, users, servers));
            } catch (IOException ex) {
                this.logger.println(ex.getMessage());
            } catch (PacketTooSmallException ex) {
                this.logger.println("Packet incompleto!");
            }
        }
    }
}
