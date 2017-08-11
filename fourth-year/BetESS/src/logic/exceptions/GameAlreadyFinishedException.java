/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.exceptions;

/**
 *
 * @author jose
 */
public class GameAlreadyFinishedException extends Exception {

    /**
     *
     */
    public GameAlreadyFinishedException() {
    }

    /**
     *
     * @param message
     */
    public GameAlreadyFinishedException(String message) {
        super(message);
    }

}
