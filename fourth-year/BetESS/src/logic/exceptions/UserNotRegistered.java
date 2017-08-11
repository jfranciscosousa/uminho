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
public class UserNotRegistered extends Exception {

    /**
     *
     */
    public UserNotRegistered() {
        super();
    }

    /**
     *
     * @param message
     */
    public UserNotRegistered(String message) {
        super(message);
    }

}
