/*
 * Copyright 2015 josesousa9000@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package Main;

import se.sics.jasper.SPException;

/**
 *
 * @author josesousa9000@gmail.com
 */
public class ProjetoSRCR {

    /**
     * @param args the command line arguments
     * @throws se.sics.jasper.SPException
     */
    public static void main(String[] args) throws SPException, Exception {
        Menu menu = new Menu();
        if (menu.StartConnection()) {
            menu.menu();
        } else {
            System.out.println("Impossivel establecer ligação");
        }

    }

}
