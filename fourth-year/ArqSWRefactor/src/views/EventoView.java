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
import java.time.Instant;
import java.util.Date;
import models.Evento;

/**
 *
 * @author joses
 */
public class EventoView {

    private BufferedReader in;
    private PrintStream out;
    private Evento evento;

    public EventoView(Evento evento) {
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
        this.evento = evento;
    }

    public String viewEvento() {
        return "Evento{"
                + "equipa1='" + evento.getEquipa1() + '\''
                + ", equipa2='" + evento.getEquipa2() + '\''
                + ", resultado_final=" + evento.getResultado()
                + ", estado=" + evento.isOpen()
                + ", data da aposta" + evento.getDataEvento().toString()
                + ", ultima odd" + evento.getOdd()
                + '}';
    }

    public void viewCreateEvento() {

        String readinput;
        this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            evento.setEquipa2(tokens[1]);
            evento.setEquipa1(tokens[0]);
            evento.setDataEvento(Date.from(Instant.now()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    public void viewUpdateEvento() {
        String readinput;
        this.out.print("Introduza as equipas participantes no evento: (Equipa1, Equipa2, DataEvento)\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");
            evento.setEquipa2(tokens[1]);
            evento.setEquipa1(tokens[0]);
            evento.setDataEvento(Date.from(Instant.now()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void viewDeleteApostador() {
        this.out.println("Remover Apostador" + this.viewEvento());

    }
}
