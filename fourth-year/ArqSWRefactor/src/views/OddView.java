/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import models.Evento;
import models.Odd;

/**
 *
 * @author joses
 */
public class OddView {

    private BufferedReader in;
    private PrintStream out;
    private Odd odd;
    
    public OddView(Odd odd){
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
        this.odd = odd;
    }

    //	Views para Odd
    public void viewCreateOdd() {
        String readinput;
        this.out.println("Introduza a odd: 1,x,2\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            odd.setOdd1(Float.parseFloat(tokens[0]));
            odd.setOddx(Float.parseFloat(tokens[1]));
            odd.setOdd2(Float.parseFloat(tokens[2]));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
