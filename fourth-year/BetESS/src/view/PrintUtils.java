/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author jose
 */
public class PrintUtils {

    /**
     *
     * @param it
     */
    public static void print(Iterable<? extends Object> it) {
        System.out.println("----------------------------------");
        for (Object o : it) {
            System.out.println(o);
        }
        System.out.println("----------------------------------");
    }
}
