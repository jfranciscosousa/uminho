package controller;

import models.Apostador;
import models.Evento;
import java.time.Instant;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Date;
import java.util.ListIterator;
import java.util.Vector;
import models.Aposta;
import models.Bookie;
import models.Observer;
import models.Odd;
import views.ApostaView;
import views.ApostadorView;
import views.BookieView;
import views.EventoView;
import views.OddView;

public class BetESSAPI implements Observer {

    private Vector<Evento> listaEventos;
    private Vector<Apostador> listaApostadores;
    private Vector<Bookie> listaBookies;
    private double betESStotal;
    private String name;

    private final BufferedReader in;
    private final PrintStream out;

    public BetESSAPI() {
        this.betESStotal = 0;
        this.listaEventos = new Vector<Evento>();
        this.listaApostadores = new Vector<Apostador>();
        this.listaBookies = new Vector<Bookie>();
        this.name = "BetESSAPI";
        this.in = new BufferedReader(new InputStreamReader(System.in));
        this.out = System.out;
    }

    public void registaAposta(Apostador apostador, Evento evento) {
        Aposta aposta = new Aposta();
        ApostaView view = new ApostaView(aposta);
        aposta.setApostador(apostador);
        view.viewCreateAposta();
        evento.registaAposta(aposta);
    }

    // Interface sobre Eventos
    public void actualizaOdd(Evento evento, int odd_1, int odd_x, int odd_2) {
        evento.setOdd(new Odd(odd_1, odd_x, odd_2));
    }

    public void actualizaOdd(Evento evento) {
        Odd odd = new Odd();
        OddView view = new OddView(odd);
        view.viewCreateOdd();
        evento.setOdd(odd);
    }

    public boolean fechaEvento(Evento evento, char resultado) {
        Evento.Resultado resultado_final;
        switch (resultado) {
            case '1':
                resultado_final = Evento.Resultado.VITORIA;
                break;
            case 'x':
                resultado_final = Evento.Resultado.EMPATE;
                break;
            case '2':
                resultado_final = Evento.Resultado.DERROTA;
                break;
            default:
                return false;
        }
        return evento.fechaEvento(resultado_final);
    }

    public boolean fechaEvento(Evento evento, char resultado, Bookie bookie) {
        Evento.Resultado resultado_final;
        switch (resultado) {
            case '1':
                resultado_final = Evento.Resultado.VITORIA;
                break;
            case 'x':
                resultado_final = Evento.Resultado.EMPATE;
                break;
            case '2':
                resultado_final = Evento.Resultado.DERROTA;
                break;
            default:
                return false;
        }
        evento.setBookieFechou(bookie);
        return evento.fechaEvento(resultado_final);
    }

    public void viewEventos() {

        ListIterator<Evento> listIterator = this.listaEventos.listIterator();
        while (listIterator.hasNext()) {
            EventoView view = new EventoView(listIterator.next());
            view.viewEvento();
        }
    }

    public Evento registaEvento(String equipa1, String equipa2) {

        Evento evento = new Evento(equipa1, equipa2, Date.from(Instant.now()));
        this.listaEventos.add(evento);
        evento.addObserver(this);
        return evento;
    }

    public Evento registaEvento() {

        Evento newevento = new Evento();
        EventoView view = new EventoView(newevento);

        view.viewCreateEvento();
        this.listaEventos.add(newevento);
        newevento.addObserver(this);
        return newevento;
    }

    public Evento registaEvento(String equipa1, String equipa2, Bookie bookie) {

        Evento evento = new Evento(equipa1, equipa2, Date.from(Instant.now()), bookie);
        this.listaEventos.add(evento);
        evento.addObserver(this);
        return evento;
    }

    public Evento registaEvento(Bookie bookie) {

        Evento newevento = new Evento();
        EventoView view = new EventoView(newevento);

        view.viewCreateEvento();
        newevento.setBookieAbriu(bookie);
        this.listaEventos.add(newevento);
        newevento.addObserver(this);
        return newevento;
    }

    // Interface sobre Apostadores
    public void viewApostadores() {
        ListIterator<Apostador> lista = this.listaApostadores.listIterator();
        while (lista.hasNext()) {
            ApostadorView view = new ApostadorView(lista.next());
            view.viewApostador();
        }
    }

    public Apostador registaApostador(String nome, String email, double coins) {
        Apostador newuser = new Apostador(nome, email, coins);
        listaApostadores.add(newuser);
        return newuser;
    }

    public Apostador registaApostador() {

        Apostador newuser = new Apostador();
        ApostadorView view = new ApostadorView(newuser);
        view.viewCreateApostador();
        this.listaApostadores.add(newuser);

        return newuser;
    }

    public Apostador actualizaApostador(Apostador apostador) {
        ApostadorView view = new ApostadorView(apostador);

        view.viewUpdateApostador();

        return apostador;
    }

    public boolean deleteApostador(Apostador apostador) {
        ApostadorView view = new ApostadorView(apostador);
        view.viewDeleteApostador();
        return this.listaApostadores.remove(apostador);

    }

    // Interface sobre Bookies
    public Bookie actualizaBookie(Bookie bookie) {
        BookieView view = new BookieView(bookie);

        view.viewUpdateBookie();

        return bookie;
    }

    public Bookie registaBookie(String nome, String email) {
        Bookie bookie = new Bookie(nome, email);
        this.listaBookies.add(bookie);
        return bookie;
    }

    public Bookie registaBookie() {
        Bookie bookie = new Bookie();
        BookieView view = new BookieView(bookie);
        view.viewCreateBookie();
        this.listaBookies.add(bookie);
        return bookie;
    }

    public void viewBookies() {
        ListIterator<Bookie> listIterator = this.listaBookies.listIterator();
        while (listIterator.hasNext()) {
            BookieView view = new BookieView(listIterator.next());
            view.viewBookie();
        }
    }

    public boolean deleteBookie(Bookie bookie) {
        BookieView view = new BookieView(bookie);
        view.viewDeleteBookie();
        return this.listaBookies.remove(bookie);
    }

    // Objects view
    @Override
    public String toString() {
        return "BetESSAPI{"
                + "name=" + name
                + ", betESStotal=" + betESStotal
                + '}';
    }

    @Override
    public void update(Object notificacao) {
        if (notificacao instanceof String) {
            String str = (String) notificacao;
            this.out.println("\nApostador(" + this.name + "):" + str + "\n");
        }

    }
}
