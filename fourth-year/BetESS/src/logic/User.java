/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import logic.observer.Observable;
import logic.observer.Observer;

/**
 *
 * @author joses
 */
public class User implements Observer {

    private String name;
    private String email;
    private String password;
    private float balance;
    private List<Bet> bets;
    private List<String> messages;
    private static final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss");

    User(String name, String email, String password, float balance) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.balance = balance;
        this.bets = new ArrayList<>();
        this.messages = new ArrayList<>();
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     *
     * @return
     */
    public float getBalance() {
        return balance;
    }

    void setPassword(String password) {
        this.password = password;
    }

    void subtractBalance(float amount) {
        this.balance -= amount;
    }

    // meti public para ser possivil meter dinheiro na conta.
    /**
     *
     * @param amount
     */
    public void addBalance(float amount) {
        this.balance += amount;
    }

    /**
     *
     * @return
     */
    public List<Bet> getBets() {
        return new ArrayList<>(bets);
    }

    /**
     *
     * @return
     */
    public List<String> getMessages() {
        return new ArrayList<>(messages);
    }

    void addMessage(String message) {
        this.messages.add(String.format("[%s] %s", LocalDateTime.now().format(DTF), message));
    }

    /**
     *
     * @param b
     */
    public void addBet(Bet b) {
        this.bets.add(b);
        b.getGame().addObserver(this);
    }

    @Override
    public String toString() {
        return "User{" + "name=" + name + ", email=" + email + ", password=" + password + ", balance=" + balance + ", bets=" + bets + '}';
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof Game) {
            Game g = (Game) o;
            if (arg instanceof Odds) {
                Odds odd = (Odds) arg;
                this.addMessage(String.format("Jogo %d possui nova odd %f | %f | %f",
                        g.getID(),
                        odd.getHome(),
                        odd.getDraw(),
                        odd.getAway()));
            } else if (arg instanceof Score) {
                Score score = (Score) arg;
                this.addMessage(String.format("%s vs %s terminado com score %d-%d",
                        g.getHomeTeam(),
                        g.getAwayTeam(),
                        score.getHome(),
                        score.getAway()));
            } else if (arg instanceof Float) {
                float profit = (Float) arg;
                this.addMessage(String.format("Acabou de ganhar %f créditos no jogo %s vs %s",
                        profit,
                        g.getHomeTeam(),
                        g.getAwayTeam()));
            }
        }
    }
}
