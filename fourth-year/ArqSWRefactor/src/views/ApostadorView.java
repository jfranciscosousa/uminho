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
import models.Aposta;
import models.Apostador;

/**
 *
 * @author joses
 */
public class ApostadorView {

    private BufferedReader in;
    private PrintStream out;
    private Apostador apostador;

    public ApostadorView(Apostador apostador) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
        this.apostador = apostador;
    }

    public void viewCreateApostador() {

        String readinput;
        this.out.print("Introduza os seguintes dados de Apostador: (Nome, email, montante betESScoins\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            apostador.setName(tokens[0]);
            apostador.setEmail(tokens[1]);
            apostador.setBetESScoins(Double.parseDouble(tokens[2]));
            this.viewApostador();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void viewUpdateApostador() {

        String readinput;
        this.out.print("Introduza novos dados de Apostador: (Nome(" + apostador.getName()+ "), email(" + apostador.getEmail() + "), montante betESScoins(" + apostador.getBetESScoins() + ")\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            apostador.setName(tokens[0]);
            apostador.setEmail(tokens[1]);
            apostador.setBetESScoins(Double.parseDouble(tokens[2]));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewDeleteApostador() {
        this.out.println("Remover Apostador" + this.viewApostador());

    }

    public String viewApostador() {

        String view;
        view = new String("Apostador{" + "email='" + apostador.getEmail() + ", betESScoins=" + apostador.getBetESScoins() + ", name='" + apostador.getName() + '\'' + '}');
        this.out.println(view);
        return view;

    }

}
