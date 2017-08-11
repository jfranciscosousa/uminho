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
package Misc;

import Net.CCPacket;
import Net.CCSocket;
import Net.ExcessBytesException;
import Net.GameError;
import Net.PacketTooSmallException;
import jaco.mp3.player.MP3Player;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.SocketAddress;
import java.net.SocketException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author josesousa9000@gmail.com
 */
public class MenuPergunta{

    private final String pergunta;
    private final String resposta1;
    private final String resposta2;
    private final String resposta3;
    private final int questao;
    private final int certa;
    private final CCSocket socket;
    private final SocketAddress server;
    private int resposta = 0;

    public MenuPergunta(CCPacket ccp, CCSocket socket) throws IOException, PacketTooSmallException, MissingFieldsException, GameError {
        try {
            String erro;

            this.server = ccp.getSender();
            this.socket = socket;
            this.certa = new BigInteger(ccp.getCampo(12)).intValue();
            List<byte[]> perguntas = ccp.getCampos(13);
            this.pergunta = new String(ccp.getCampo(11));
            this.resposta1 = new String(perguntas.get(0));
            this.resposta2 = new String(perguntas.get(1));
            this.resposta3 = new String(perguntas.get(2));
            this.questao = new BigInteger(ccp.getCampo(10)).intValue();

            CCPacket rep = new CCPacket(0, 0, ccp.getLabel(), 0);
            socket.send(rep, ccp.getSender());
            receiveFile(socket, "temp.jpg");
            receiveFile(socket, "temp.mp3");
        } catch (NullPointerException ex) {
            throw new MissingFieldsException("Campos em falta!");
        }
    }

    private static void receiveFile(CCSocket socket, String filename) throws FileNotFoundException, IOException{
        CCPacket ccp;
        boolean done = false, good = false;
        FileOutputStream fos = new FileOutputStream(filename);
        byte data[] = ArrayUtils.EMPTY_BYTE_ARRAY, aux[];
        while (!done) {
            try {
                ccp = socket.receive();
                if (ccp.getCampo(254) == null) {
                    done = true;
                }
                //envia reply
                socket.send(new CCPacket(0, 0, ccp.getLabel(), 0), ccp.getSender());
                aux = ccp.getCampo(18);
                if (aux == null) {
                    //teremos confiança no senhor deus, nada de mal acontece!
                    ;
                }
                //concatenar bloco de dados ao total
                data = ArrayUtils.addAll(data, aux);
            } catch (IOException | PacketTooSmallException | GameError ex) {
                System.out.println(ex.getMessage());
                return;
            }
        }
        fos.write(data);
        fos.close();
    }

    private void sendResposta(int resposta) throws ExcessBytesException, SocketException, IOException, GameError, PacketTooSmallException {
        CCPacket ccp = new CCPacket(0, 0, new Random(LocalDateTime.now().getNano()).nextInt(), 11);
        ccp.addCampo(6, BigInteger.valueOf(resposta).toByteArray());
        ccp.addCampo(10, BigInteger.valueOf(this.questao).toByteArray());
        socket.send(ccp, this.server);
        socket.setTimeout(500);
        socket.receive();
        socket.setTimeout(0);
    }

    public void run() {
        //executar a pergunta durante um minuto
        ExecutorService service = Executors.newSingleThreadExecutor();
        final Scanner in = new Scanner(System.in);
        File file = new File("temp.mp3");
        MP3Player player = new MP3Player(file);
        try {
            Runnable r;
            r = () -> {
                System.out.println(pergunta);

                player.play();

                System.out.println("1 - " + this.resposta1);
                System.out.println("2 - " + this.resposta2);
                System.out.println("3 - " + this.resposta3);
                System.out.println("Qual a resposta correta?");
                this.resposta = in.nextInt();
                if (this.resposta == this.certa) {
                    System.out.println("Resposta correta!");
                } else {
                    System.out.println("Resposta errada!");
                }
            };
            Future<?> f = service.submit(r);

            f.get(1, TimeUnit.MINUTES);     // attempt the task for one minutes
        } catch (final InterruptedException e) {
            System.out.println("InterruptedException!");
        } catch (final TimeoutException e) {
            //enviar resposta errada
            System.out.println("Time is up! Não respondeu a tempo");
        } catch (final ExecutionException e) {
            System.out.println("ExecutionException!");
        } finally {
            try {
                sendResposta(resposta);
            } catch (ExcessBytesException | IOException | GameError | PacketTooSmallException ex) {
                System.out.println(ex.getMessage());
            }
            in.nextLine();
            player.stop();
            file.delete();
            service.shutdown();
        }
    }
}
