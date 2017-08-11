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
import models.Evento;

/**
 *
 * @author joses
 */
public class ApostaView {

    private BufferedReader in;
    private PrintStream out;
    private Aposta aposta;
    
    public ApostaView(Aposta aposta){
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
        this.aposta = aposta;
    }

    //	Views para Apostador
    public void viewCreateAposta() {
        String readinput;
        this.out.println("Introduza o resultado e o montante a apostar: montante, resultado\n");
        try {
            readinput = this.in.readLine();
            String[] tokens = readinput.split(",");

            switch (tokens[1]) {
                case "1":
                    aposta.setResultado(Evento.Resultado.VITORIA);
                    break;
                case "x":
                    aposta.setResultado(Evento.Resultado.EMPATE);
                    break;
                case "2":
                    aposta.setResultado(Evento.Resultado.DERROTA);
                    break;
            }

            aposta.setM_aposta(Float.parseFloat(tokens[0]));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
