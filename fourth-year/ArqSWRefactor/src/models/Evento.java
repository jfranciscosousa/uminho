package models;

import java.util.Date;
import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class Evento implements Subject {

    public enum Resultado {

        VITORIA,
        DERROTA,
        EMPATE
    }

    private static AtomicInteger uniqueId = new AtomicInteger();

    private String equipa1;
    private String equipa2;
    private Resultado resultado_final;
    private Date dataEvento;
    private int id;
    private Vector<Aposta> listaApostas;
    private Vector<Observer> observers;
    private boolean isOpen;
    private Odd odds;
    private Bookie bookieAbriu;
    private Bookie bookieFechou;

    public Evento(String equipa1, String equipa2, Date data) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.isOpen = false;
        this.resultado_final = null;
        this.dataEvento = data;
        this.id = uniqueId.getAndIncrement();
        this.odds = new Odd();
        this.listaApostas = new Vector<Aposta>();
        this.observers = new Vector<Observer>();
    }

    public Evento(String equipa1, String equipa2, Date data, Bookie bookieAbriu) {
        this.equipa1 = equipa1;
        this.equipa2 = equipa2;
        this.isOpen = false;
        this.resultado_final = null;
        this.dataEvento = data;
        this.id = uniqueId.getAndIncrement();
        this.odds = new Odd();
        this.listaApostas = new Vector<Aposta>();
        this.observers = new Vector<Observer>();
        this.bookieAbriu = bookieAbriu;
    }

    public Evento() {
        this.equipa1 = null;
        this.equipa2 = null;
        this.isOpen = false;
        this.resultado_final = null;
        this.dataEvento = null;
        this.id = uniqueId.getAndIncrement();
        this.odds = new Odd();
        this.listaApostas = new Vector<Aposta>();
        this.observers = new Vector<Observer>();
    }

    public Bookie getBookieAbriu() {
        return bookieAbriu;
    }

    public void setBookieAbriu(Bookie bookieAbriu) {
        this.bookieAbriu = bookieAbriu;
    }

    public Bookie getBookieFechou() {
        return bookieFechou;
    }

    public void setBookieFechou(Bookie bookieFechou) {
        this.bookieFechou = bookieFechou;
    }

    public String getEquipa1() {
        return this.equipa1;
    }

    public void setEquipa1(String equipa1) {
        this.equipa1 = equipa1;
    }

    public String getEquipa2() {
        return this.equipa2;
    }

    public void setEquipa2(String equipa2) {
        this.equipa2 = equipa2;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Date getDataEvento() {
        return this.dataEvento;
    }

    public boolean fechaEvento(Evento.Resultado resultado_final) {
        this.resultado_final = resultado_final;
        this.isOpen = false;
        this.notifyObservers();
        return true;
    }

    public boolean fechaEvento(Evento.Resultado resultado_final, Bookie bookieFechou) {
        this.resultado_final = resultado_final;
        this.isOpen = false;
        this.notifyObservers();
        this.bookieFechou = bookieFechou;
        return true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public Resultado getResultado() {
        return this.resultado_final;
    }

    public void registaAposta(Aposta aposta) {
        aposta.setOdd_fixada(this.odds);

        this.listaApostas.add(aposta);

    }

    public void setOdd(Odd odd) {
        this.odds = odd.clone();
    }

    public Odd getOdd() {
        return this.odds.clone();
    }

    @Override
    public void notifyObservers() {
        if (!this.isOpen) {
            for (Aposta aposta : listaApostas) {
                float premio = aposta.calculaPremio(resultado_final);
                aposta.getApostador().update(premio);
                sendNotifications("" + premio);
            }
        }
    }

    private void sendNotifications(String notif) {
        for (Observer observer : observers) {
            observer.update(notif);
        }
    }

    @Override
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }
}
