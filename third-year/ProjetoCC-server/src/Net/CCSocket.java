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
package Net;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.net.SocketException;

/**
 *
 * @author José
 */
public class CCSocket {

    private final DatagramSocket socket;

    public CCSocket() throws SocketException {
        this.socket = new DatagramSocket();
    }

    public CCSocket(int port) throws SocketException {
        this.socket = new DatagramSocket(port);
    }

    public void send(CCPacket ccp, SocketAddress addr) throws IOException {
        byte payload[] = ccp.toBytes();
        DatagramPacket packet = new DatagramPacket(payload, payload.length, addr);
        this.socket.send(packet);
    }

    public void broadcast(CCPacket ccp) throws IOException {
        socket.setBroadcast(true);
        InetAddress sendAddress = InetAddress.getByName("255.255.255.255");
        byte payload[] = ccp.toBytes();
        DatagramPacket packet = new DatagramPacket(payload, payload.length, sendAddress, 1234);
        this.socket.send(packet);
        socket.setBroadcast(false);
    }

    public CCPacket receive() throws IOException, PacketTooSmallException{
        byte payload[] = new byte[48000];
        DatagramPacket packet = new DatagramPacket(payload, 48000);
        this.socket.receive(packet);
        CCPacket ccp = new CCPacket(payload, packet.getSocketAddress());
        return ccp;
    }

    public void setTimeout(int time) throws SocketException {
        this.socket.setSoTimeout(time);
    }
}
