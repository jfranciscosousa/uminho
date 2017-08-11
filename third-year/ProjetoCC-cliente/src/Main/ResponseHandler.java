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

import Net.CCPacket;
import java.math.BigInteger;

/**
 *
 * @author josesousa9000@gmail.com
 */
public class ResponseHandler {

    public static void registerHandler(CCPacket ccp) {
        if (ccp.getTipo() != 0) {
            System.out.println("Tipo inesperado!");
            return;
        }
        System.out.format("Utilizador registado com sucesso!\n");
    }

    public static void loginHandler(CCPacket ccp) {
        if (ccp.getTipo() != 0) {
            System.out.println("Tipo inesperado!");
            return;
        }
        String user = new String(ccp.getCampo(1));
        int score = new BigInteger(ccp.getCampo(20)).intValue();
        System.out.format("Utilizador %s logado com sucesso! %d pontos\n",
                user,
                score);
    }

    public static void logoutHandler(CCPacket ccp) {
        if (ccp.getTipo() != 0) {
            System.out.println("Tipo inesperado!");
        }
        System.out.println("Logout com sucesso!");
    }

    public static void quitHandler(CCPacket ccp) {
        if (ccp.getTipo() != 0) {
            System.out.println("Tipo inesperado!");
            return;
        }
        System.out.println("Desitiu com sucesso!");
    }
    
        public static void endHandler(CCPacket ccp) {
        if (ccp.getTipo() != 0) {
            System.out.println("Tipo inesperado!");
            return;
        }
        System.out.println("Terminou com sucesso!");
    }
}
