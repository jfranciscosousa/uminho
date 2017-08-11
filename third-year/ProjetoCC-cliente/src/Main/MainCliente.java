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
package Main;

import Misc.MenuPergunta;
import Misc.MissingFieldsException;
import Misc.Security;
import Net.CCSocket;
import Net.CCPacket;
import Net.ExcessBytesException;
import Net.GameError;
import Net.PacketTooSmallException;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class MainCliente {

    private final static Random random = new Random();

    private static void findServer() throws SocketException, IOException, PacketTooSmallException, GameError {
        CCSocket socket = new CCSocket();
        CCPacket ccp = new CCPacket(0, 0, random.nextInt(), 1), rec = null;
        socket.broadcast(ccp);
        boolean end = false;
        while (!end) {
            socket.setTimeout(500);
            try {
                rec = socket.receive();
            } catch (PacketTooSmallException ex) {
                //
            } catch (SocketTimeoutException ex) {
                end = true;
            }
            socket.setTimeout(0);
        }
        if (rec != null) {
            System.out.format("Encontrado servidor de jogo! Endereço:%s\n",
                    rec.getSender().toString());
            menu(rec.getSender(), socket);
        } else {
            System.out.println("Servers offline! Tente mais tarde");
        }
    }

    private static void connectServer(String hostname) throws SocketException, IOException, SocketTimeoutException, PacketTooSmallException, GameError {
        CCSocket socket = new CCSocket();
        CCPacket ccp = new CCPacket(0, 0, random.nextInt(), 1), rec = null;
        socket.send(ccp, new InetSocketAddress(hostname, 1234));
        socket.setTimeout(500);
        rec = socket.receive();
        socket.setTimeout(0);
        menu(rec.getSender(), socket);
    }

    public static void main(String[] argv) {
        try {
            Scanner scan = new Scanner(System.in);
            System.out.println("Deseja-se connectar a um servidor especifico? S/N");
            if (!scan.nextLine().equals("S")) {
                findServer();
            } else {
                System.out.println("Escreva endereço do servidor");
                connectServer(scan.nextLine());
            }
        } catch (SocketTimeoutException ex) {
            System.out.println("Server offline!");
        } catch (SocketException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (GameError | PacketTooSmallException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void menu(SocketAddress server, CCSocket socket) throws IOException, PacketTooSmallException {

        Scanner in = new Scanner(System.in);

        boolean ok = false, error = false;
        int timeout = 500;

        CCPacket ccp;
        int opcao;
        String nome;
        String alcunha;
        String secinfo;
        String desafio;
        String data = null;
        String hora = null;
        int escolha;
        int questao;
        int bloco;
        String opcoes[] = {"Hello",
            "Registo",
            "Login",
            "Logout",
            "Desistir",
            "Terminar",
            "Lista de Desafios",
            "Realizar Desafio",
            "Aceitar Desafio",
            "Eliminar Desafio",
            "Ranking",
            "Jogar"};

        do {
            try {
                error = false;
                for (int i = 1; i <= opcoes.length; i++) {
                    System.out.println(i + " - " + opcoes[i - 1]);
                }
                System.out.println("Escolha a opcao");
                opcao = in.nextInt();
                in.nextLine();

                switch (opcao) {

                    case 1:
                        break;

                    case 2:
                        System.out.println("Introduza o seu nome");
                        nome = in.nextLine();
                        System.out.println("Introduza a sua alcunha");
                        alcunha = in.nextLine();
                        System.out.println("Introduza a sua password");
                        secinfo = in.nextLine();
                        secinfo = Security.encrypt(secinfo);
                        ccp = new CCPacket(0, 1, random.nextInt(), 2);
                        try {
                            ccp.addCampo(1, nome.getBytes());
                            ccp.addCampo(2, alcunha.getBytes());
                            ccp.addCampo(3, secinfo.getBytes());
                            socket.send(ccp, server);
                            socket.setTimeout(timeout);
                            ccp = socket.receive();
                            socket.setTimeout(0);
                            ResponseHandler.registerHandler(ccp);
                        } catch (ExcessBytesException e) {
                            System.out.println("Limite de bytes ultrapassado! Tente de novo");
                        }
                        break;

                    case 3:
                        System.out.println("Introduza a sua alcunha");
                        alcunha = in.nextLine();
                        System.out.println("Introduza a sua password");
                        secinfo = in.nextLine();
                        secinfo = Security.encrypt(secinfo);
                        ccp = new CCPacket(0, 1, random.nextInt(), 3);
                        try {
                            ccp.addCampo(2, alcunha.getBytes());
                            ccp.addCampo(3, secinfo.getBytes());
                            socket.send(ccp, server);
                            socket.setTimeout(timeout);
                            ccp = socket.receive();
                            socket.setTimeout(0);
                            ResponseHandler.loginHandler(ccp);
                        } catch (ExcessBytesException e) {
                            System.out.println("Limite de bytes ultrapassado! Tente de novo");
                        }
                        break;

                    case 4:
                        ccp = new CCPacket(0, 0, random.nextInt(), 4);
                        socket.send(ccp, server);
                        socket.setTimeout(timeout);
                        ccp = socket.receive();
                        ResponseHandler.logoutHandler(ccp);
                        socket.setTimeout(0);
                        break;

                    case 5:
                        ccp = new CCPacket(0, 0, random.nextInt(), 5);
                        socket.send(ccp, server);
                        socket.setTimeout(timeout);
                        ccp = socket.receive();
                        ResponseHandler.quitHandler(ccp);
                        socket.setTimeout(0);
                        break;

                    case 6:
                        ccp = new CCPacket(0, 0, random.nextInt(), 6);
                        socket.send(ccp, server);
                        socket.setTimeout(timeout);
                        ccp = socket.receive();
                        ResponseHandler.endHandler(ccp);
                        socket.setTimeout(0);
                        break;

                    case 7:
                        ccp = new CCPacket(0, 0, random.nextInt(), 7);
                        socket.send(ccp, server);
                        socket.setTimeout(timeout);
                        ccp = socket.receive();
                        socket.setTimeout(0);
                        DateTimeFormatter dtf
                                = DateTimeFormatter.ofPattern("yyMMddHHmmss");
                        List<byte[]> nomes,
                         datas,
                         horas;
                        nomes = ccp.getCampos(7);
                        datas = ccp.getCampos(4);
                        horas = ccp.getCampos(5);
                        System.out.println("Formato das datas -> dd-MM-yyyy HH:mm:ss");
                        for (int i = 0; i < nomes.size(); i++) {
                            String dataS = new String(datas.get(i)) + new String(horas.get(i));
                            System.out.format("Desafio %s Data %s\n",
                                    new String(nomes.get(i)),
                                    LocalDateTime.parse(dataS, dtf).format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
                        }
                        break;

                    case 8:
                        System.out.println("Introduza o nome do desafio");
                        desafio = in.nextLine();
                        data = null;
                        hora = null;
                        System.out.println("Deseja marcar para uma data em especifico? Y/N");
                        if (in.nextLine().equals("Y")) {
                            System.out.println("Introduza a data do desafio (AAMMDD)");
                            while (!ok) {
                                data = in.nextLine();
                                ok = data.length() == 6;
                                if (!ok) {
                                    System.out.println("Hora errada! Reintroduza sff");
                                }
                            }
                            ok = false;
                            System.out.println("Introduza a hora do desafio (HHMMSS)");
                            while (!ok) {
                                hora = in.nextLine();
                                ok = hora.length() == 6;
                                if (!ok) {
                                    System.out.println("Hora errada! Reintroduza sff");
                                }
                            }
                            ok = false;
                        }
                        ccp = new CCPacket(0, 0, random.nextInt(), 8);
                        try {
                            ccp.addCampo(7, desafio.getBytes());
                            if (data != null && hora != null) {
                                ccp.addCampo(4, data.getBytes());
                                ccp.addCampo(5, hora.getBytes());
                            }
                            socket.send(ccp, server);
                            socket.setTimeout(timeout);
                            System.out.println(socket.receive().getCamposMapStrings().entrySet());
                            socket.setTimeout(0);
                            if (data != null && hora != null) {
                                System.out.println("Desafio marcado com sucesso");
                            } else {
                                System.out.println("Desafio marcado com sucesso!"
                                        + " Começa dentro de 5 minutos!");
                            }
                        } catch (ExcessBytesException e) {
                            System.out.println("Limite de bytes ultrapassado! Tente de novo");
                        }
                        break;

                    case 9:
                        System.out.println("Introduza o nome do desafio");
                        desafio = in.nextLine();
                        ccp = new CCPacket(0, 0, random.nextInt(), 9);
                        try {
                            ccp.addCampo(7, desafio.getBytes());
                            socket.send(ccp, server);
                            socket.setTimeout(timeout);
                            System.out.println(socket.receive().getCamposMapStrings().entrySet());
                            socket.setTimeout(0);
                        } catch (ExcessBytesException e) {
                            System.out.println("Limite de bytes ultrapassado! Tente de novo");
                        }
                        break;

                    case 10:
                        System.out.println("Introduza o nome do desafio");
                        desafio = in.nextLine();
                        ccp = new CCPacket(0, 0, random.nextInt(), 10);
                        try {
                            ccp.addCampo(7, desafio.getBytes());
                            socket.send(ccp, server);
                            socket.setTimeout(timeout);
                            System.out.println(socket.receive().getCamposMapStrings().entrySet());
                            socket.setTimeout(0);
                        } catch (ExcessBytesException e) {
                            System.out.println("Limite de bytes ultrapassado! Tente de novo");
                        }
                        break;

                    case 11:
                        System.out.println("Ranking");
                        ccp = new CCPacket(0, 0, random.nextInt(), 13);
                        socket.send(ccp, server);
                        socket.setTimeout(timeout);
                        CCPacket aux = socket.receive();
                        socket.setTimeout(0);
                        List<byte[]> names,
                         nicks,
                         pontos;
                        names = aux.getCampos(1);
                        nicks = aux.getCampos(2);
                        pontos = aux.getCampos(20);
                        for (int i = 0; i < names.size(); i++) {
                            System.out.format("Nome %s | Nick %s | Pontos %d\n",
                                    new String(names.get(i)),
                                    new String(nicks.get(i)),
                                    new BigInteger(pontos.get(i)).intValue());
                        }
                        break;
                    case 12:
                        try {
                            for (int i = 0; i < 10 && !error; i++) {
                                ccp = new CCPacket(0, 0, random.nextInt(), 20);
                                socket.send(ccp, server);
                                new MenuPergunta(socket.receive(), socket).run();

                            }
                        } catch (IOException | PacketTooSmallException | MissingFieldsException ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;

                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (GameError e) {
                System.out.println(e.getMessage());
                error = true;
            } catch (SocketTimeoutException ex) {
                System.out.println("Servers offline!");
                return;
            } catch (Exception ex) {
                System.out.println("Encription exception! " + ex.getMessage());
            }
        } while (true);
    }
}
