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
import models.Bookie;

/**
 *
 * @author joses
 */
public class BookieView {

    private BufferedReader in;
    private PrintStream out;
    private Bookie bookie;

    public BookieView(Bookie bookie) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
        this.bookie = bookie;
    }

    public void viewCreateBookie() {

        String readinput;
        this.out.print("Introduza os seguintes dados de Bookie: (Nome, email)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            bookie.setName(tokens[0]);
            bookie.setEmail(tokens[1]);
            this.viewBookie();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void viewUpdateBookie() {

        String readinput;
        this.out.print("Introduza novos dados de Bookie: (Nome(" + bookie.getName()+ "), email(" + bookie.getEmail() + "))\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            bookie.setName(tokens[0]);
            bookie.setEmail(tokens[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewDeleteBookie() {
        this.out.println("Remover Bookie" + this.viewBookie());

    }

    public String viewBookie() {

        String view;
        view = "Bookie{" + "email='" + bookie.getEmail() + ", name='" + bookie.getName() + '\'' + '}';
        this.out.println(view);
        return view;

    }

}

