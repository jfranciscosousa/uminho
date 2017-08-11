/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.exceptions;

/**
 *
 * @author joses
 */
public class GameDoesntExist extends Exception {

    /**
     * Creates a new instance of <code>GameDoesntExist</code> without detail
     * message.
     */
    public GameDoesntExist() {
    }

    /**
     * Constructs an instance of <code>GameDoesntExist</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public GameDoesntExist(String msg) {
        super(msg);
    }
}
