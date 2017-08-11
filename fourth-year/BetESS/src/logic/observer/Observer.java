/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.observer;

import logic.Bookie;

/**
 *
 * @author jose
 */
public interface Observer {
    void update(Observable o, Object arg);
}
