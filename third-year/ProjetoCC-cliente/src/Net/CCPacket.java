/* 
 * Copyright (C) 2015 josesousa9000@gmail.com
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.math.BigInteger;
import java.net.SocketAddress;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.ArrayUtils;

/**
 *
 * @author José
 */
public class CCPacket {

    private byte data[];
    private SocketAddress sender;

    /**
     * Constrói um pacote de dados dado um array de bytes, que deve originar dum
     * DatagramPacket. Também contém o respetivo emissor (endereço do mesmo)
     *
     * @param data Pacote de dados sob a forma de um array de bytes
     * @param adr Endereço que enviou a informação presente no array de bytes
     * @throws Net.PacketTooSmallException Caso o array de bytes não possua a
     * informação necessária a formação de um pacote
     */
    public CCPacket(byte data[], SocketAddress adr) throws PacketTooSmallException {
        if (data.length < 8) {
            throw new PacketTooSmallException();
        }
        this.data = data;
        this.sender = adr;
    }

    /**
     * Constrói um pacote de dados vazio, só com as informações base do header.
     * Este construtor deve ser usado para pacotes que irão ser enviados!
     * @param versao Versão do pacote de dados
     * @param seguranca Valor 0 indica que os campos não estão encriptados, um
     * valor diferente indica que os campos estão encriptados.
     * @param label Label do tipo de dados
     * @param tipo Tipo do pacote de dados
     */
    public CCPacket(int versao, int seguranca, int label, int tipo) {
        this.data = ArrayUtils.add(data, (byte) versao);
        this.data = ArrayUtils.add(data, (byte) seguranca);
        byte labelArr[] = BigInteger.valueOf((short) label).toByteArray();
        if (labelArr.length == 1) {
            labelArr = ArrayUtils.add(labelArr, (byte) 0);
            ArrayUtils.reverse(labelArr);
        }
        this.data = ArrayUtils.addAll(this.data, labelArr);
        this.data = ArrayUtils.add(data, (byte) tipo);
        //set nr campos a 0
        this.data = ArrayUtils.add(data, (byte) 0);
        //set campos size a 0
        this.data = ArrayUtils.add(data, (byte) 0);
        this.data = ArrayUtils.add(data, (byte) 0);
    }

    /**
     * Adiciona um campo ao pacote de dados, podem existir vários campos com o
     * mesmo identificador.
     *
     * @param n Identificador de campo
     * @param campo Array de bytes a ser associado
     * @throws ExcessBytesException Caso o pacote de dados exceda o limite
     * máximo de 48000 bytes
     */
    public void addCampo(int n, byte[] campo) throws ExcessBytesException {
        byte nr = (byte) n;
        if (campo.length > 48000) {
            throw new ExcessBytesException();
        }
        this.data[5]++;
        //adicionar length ao header do campo
        byte campoHeader[] = BigInteger.valueOf((short) campo.length).toByteArray();
        if (campoHeader.length == 1) {
            campoHeader = ArrayUtils.add(campoHeader, 0, (byte) 0);
        }
        //adicionar nr do campo ao header
        campoHeader = ArrayUtils.add(campoHeader, 0, nr);
        //colocar header à cabeça dos dados
        campoHeader = ArrayUtils.addAll(campoHeader, campo);
        this.data = ArrayUtils.addAll(this.data, campoHeader);
        int size = this.getSizeListaCampos();
        //atualizar header do pacote, indicando o novo tamanho dos campos
        byte labelArr[] = BigInteger.valueOf((short) (size + campo.length)).toByteArray();
        if (labelArr.length == 1) {
            labelArr = ArrayUtils.add(labelArr, 0, (byte) 0);
        }
        this.data[6] = labelArr[0];
        this.data[7] = labelArr[1];
    }

    /**
     * Obtém o primeiro campo com o identificador n
     *
     * @param n Identificador do campo a obter
     * @return Array de bytes com os dados respetivos, ou null caso não exista
     * nenhum campo com esse identificador
     */
    public byte[] getCampo(int n) {
        int sizeCampo;
        byte res[] = null, aux[];
        for (int i = 0, j = 8; i < this.getNrCampos(); i++) {
            sizeCampo = Short.toUnsignedInt(new BigInteger(ArrayUtils.subarray(this.data, j + 1, j + 3)).shortValue());
            aux = ArrayUtils.subarray(this.data, j + 3, j + 3 + sizeCampo);
            if (Byte.toUnsignedInt(this.data[j]) == n) {
                res = aux;
                break;
            }
            j += 3 + sizeCampo;
        }
        return res;
    }

    /**
     * Obtém todos os campos com o identificador n
     *
     * @param n Identificador dos campos a obter
     * @return Lista com todos os arrays de bytes com o identificador n
     */
    public List<byte[]> getCampos(int n) {
        int sizeCampo;
        List<byte[]> campos = new LinkedList<>();
        byte aux[];
        for (int i = 0, j = 8; i < this.getNrCampos(); i++) {
            sizeCampo = Short.toUnsignedInt(new BigInteger(ArrayUtils.subarray(this.data, j + 1, j + 3)).shortValue());
            aux = ArrayUtils.subarray(this.data, j + 3, j + 3 + sizeCampo);
            if (Byte.toUnsignedInt(this.data[j]) == n) {
                campos.add(aux);

            }
            j += 3 + sizeCampo;
        }
        return campos;
    }

    /**
     * Retorna o array de bytes deste pacote de dados
     *
     * @return Array de bytes do pacote de dados
     */
    public byte[] toBytes() {
        return this.data;
    }

    /**
     * Método para obter a versão deste pacote de dados
     *
     * @return Versão do pacote de dados
     */
    public byte getVersao() {
        return data[0];
    }

    /**
     * Método para obter o tipo de segurança utilizado neste pacote de dados
     *
     * @return Tipo de segurança usado
     */
    public byte getSeguranca() {
        return data[1];
    }

    /**
     * Método para obter a label utilizada por este pacote de dados
     *
     * @return Label do pacote de dados
     */
    public short getLabel() {
        return (short) new BigInteger(ArrayUtils.subarray(this.data, 2, 4)).intValue();
    }

    /**
     * Método que permite obter o tipo deste pacote de dados
     *
     * @return Tipo do pacote de dados
     */
    public byte getTipo() {
        return data[4];
    }

    /**
     * Método que permite alterar o tipo deste pacote de dados
     *
     * @param tipo Novo tipo deste pacote de dados
     */
    public void setTipo(int tipo) {
        data[4] = (byte) tipo;
    }

    /**
     * Método para obter o SocketAddress do emissor deste pacote de dados
     *
     * @return SocketAddress do utilizador que enviou este pacote, NULL para
     * pacotes gerados na própria máquina
     */
    public SocketAddress getSender() {
        return sender;
    }

    /**
     * Método que permite obter o número de campos deste pacote de dados
     *
     * @return O número de campos presente neste campo de dados
     */
    public byte getNrCampos() {
        return data[5];
    }

    /**
     * Método que permite obter o número de bytes total da lista de campos,
     * headers de campo incluídos.
     *
     * @return
     */
    public int getSizeListaCampos() {
        return Short.toUnsignedInt((short) new BigInteger(ArrayUtils.subarray(this.data, 6, 8)).intValue());
    }

    /**
     * Método que permite obter um map que associa o número de campo à sua
     * informação, neste caso, um array de bytes. Caso existam vários campos com
     * o mesmo ID, apenas o último campo irá ficar presente no Map
     *
     * @return Map que associa o número de campo à um array de bytes
     */
    public Map<Integer, byte[]> getCamposMap() {
        HashMap<Integer, byte[]> map = new HashMap<>();
        int sizeCampo;
        byte aux[];
        for (int i = 0, j = 8; i < this.getNrCampos(); i++) {
            sizeCampo = Short.toUnsignedInt(new BigInteger(ArrayUtils.subarray(this.data, j + 1, j + 3)).shortValue());
            aux = ArrayUtils.subarray(this.data, j + 3, j + 3 + sizeCampo);
            map.put(Byte.toUnsignedInt(this.data[j]), aux);
            j += 3 + sizeCampo;
        }
        return map;
    }

    /**
     * Método que permite obter um map que associa o número de campo à sua
     * informação, neste caso, uma string. Caso existam vários campos com o
     * mesmo ID, apenas o último campo irá ficar presente no Map
     *
     * @return Map que associa o número de campo à uma string
     */
    public Map<Integer, String> getCamposMapStrings() {
        HashMap<Integer, String> map = new HashMap<>();
        int sizeCampo;
        byte aux[];
        for (int i = 0, j = 8; i < this.getNrCampos(); i++) {
            sizeCampo = Short.toUnsignedInt(new BigInteger(ArrayUtils.subarray(this.data, j + 1, j + 3)).shortValue());
            aux = ArrayUtils.subarray(this.data, j + 3, j + 3 + sizeCampo);
            map.put(Byte.toUnsignedInt(this.data[j]), new String(aux));
            j += 3 + sizeCampo;
        }
        return map;
    }
}
