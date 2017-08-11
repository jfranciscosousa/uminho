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
import Net.PacketTooSmallException;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 * @author José Sousa & Nuno Carvalho
 */
public class ServerHandler implements Runnable {

    //socket do servidor "irmao"
    private final PrintWriter logger;
    private final Socket socket;
    private final Map<String, User> users;
    private final InputStream stream;
    private final LinkedBlockingQueue<Socket> servers;

    public ServerHandler(PrintWriter logger, Socket socket, Map<String, User> users, LinkedBlockingQueue<Socket> servers) throws IOException {
        this.logger = logger;
        this.socket = socket;
        this.users = users;
        this.stream = socket.getInputStream();
        this.servers = servers;
    }

    @Override
    public void run() {
        try {
            while (true) {
                byte bytes[] = new byte[50000];
                this.stream.read(bytes);
                CCPacket ccp = new CCPacket(bytes, this.socket.getRemoteSocketAddress());
                if (ccp.getTipo() == 15) {
                    String nome, nick;
                    nome = new String(ccp.getCampo(1));
                    nick = new String(ccp.getCampo(2));
                    int pontos = new BigInteger(ccp.getCampo(20)).intValue();
                    User u = this.users.get(nick);
                    if (u==null)
                        u = new User(nome, nick, "");
                    u.addScoreGlobal(pontos);
                    this.users.put(nick, u);
                    this.logger.println("Registado utilizador EXTRA-SERVIDOR!");
                    this.logger.format("Nome: %s Nick: %s\n", nome, nick);
                } else if (ccp.getTipo() == 14) {
                    byte address[] = ccp.getCampo(30);
                    int port = new BigInteger(ccp.getCampo(31)).intValue();
                    InetAddress iaddr = InetAddress.getByAddress(address);
                    this.servers.add(new Socket(iaddr, port));
                    this.logger.println("Registado novo SERVIDOR!!");
                    this.logger.format("Endereço: %s\n", iaddr);
                }
            }
        } catch (IOException ex) {
            this.logger.println(ex.getMessage());
        } catch (PacketTooSmallException ex) {
            this.logger.println("ExcessBytes! SERVERHANDLER");
        }
    }
}
