package logic;

import logic.exceptions.GameAlreadyFinishedException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import logic.observer.Observable;
import logic.observer.Observer;

/**
 * Jogo notifica User quando acaba (score final) e quando muda a odd
 *
 * @author joses
 */
public class Game implements Observable{

    private final int ID;
    private final Sport sport;
    private final Bookie bookie;
    private final String homeTeam;
    private final String awayTeam;
    private int home;
    private int away;
    private float homeOdd;
    private float awayOdd;
    private float drawOdd;
    private final LocalDateTime date;
    private final List<Bet> bets;
    private final Map<LocalDateTime, Odds> historicOdds;
    private final Set<Observer> observers;

    Game(int ID, Sport sport, Bookie bookie, String homeTeam, String awayTeam, float homeOdd, float awayOdd, float drawOdd, LocalDateTime date) {
        this.ID = ID;
        this.sport = sport;
        this.bookie = bookie;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.home = -1;
        this.away = -1;
        this.homeOdd = homeOdd;
        this.awayOdd = awayOdd;
        this.drawOdd = drawOdd;
        this.date = date;
        this.bets = new ArrayList<>();
        this.historicOdds = new TreeMap<>();
        this.historicOdds.put(LocalDateTime.now(), new Odds(homeOdd, drawOdd, awayOdd));
        this.observers = new HashSet<>();
        this.observers.add(bookie);
    }

    /**
     *
     * @return
     */
    public int getID() {
        return this.ID;
    }

    /**
     *
     * @return
     */
    public Sport getSport() {
        return this.sport;
    }

    /**
     *
     * @return
     */
    public Bookie getBookie() {
        return bookie;
    }

    /**
     *
     * @return
     */
    public float getHomeOdd() {
        return this.homeOdd;
    }

    /**
     *
     * @return
     */
    public float getDrawOdd() {
        return this.drawOdd;
    }

    /**
     *
     * @return
     */
    public float getAwayOdd() {
        return this.awayOdd;
    }

    void setOdd(Odds odd) {
        this.homeOdd = odd.getHome();
        this.drawOdd = odd.getDraw();
        this.awayOdd = odd.getAway();
        this.historicOdds.put(LocalDateTime.now(), new Odds(homeOdd, drawOdd, awayOdd));
        this.notifyObservers(odd);
    }

    /**
     *
     * @return
     */
    public String getHomeTeam() {
        return this.homeTeam;
    }

    /**
     *
     * @return
     */
    public String getAwayTeam() {
        return this.awayTeam;
    }

    private void finalizeBet(Bet b, Score s) {
        User u = b.getUser();
        if (b.getResult().equals(s.getResult())) {
            Float profit = 0f;
            switch (b.getResult()) {
                case AWAY:
                    profit = b.getBetValue() * b.getAwayOdd();
                    break;
                case HOME:
                    profit = b.getBetValue() * b.getHomeOdd();
                    break;
                case DRAW:
                    profit = b.getBetValue() * b.getDrawOdd();
                    break;
            }
            if (profit > 0) {
                this.notifyObservers(profit);
            }
            u.addBalance(profit);
            b.setFinalized();
        }
    }

    void setScore(Score score) throws GameAlreadyFinishedException {
        if (isFinished()) {
            throw new GameAlreadyFinishedException("Game already finished!");
        }
        this.away = score.getAway();
        this.home = score.getHome();
        this.notifyObservers(score);
        for (Bet b : this.bets) {
            finalizeBet(b, score);
        }
    }

    /**
     *
     * @return
     */
    public Score getScore() {
        return new Score(this.home, this.away);
    }

    /**
     *
     * @return
     */
    public boolean isFinished() {
        return !(this.away == -1 && this.home == -1);
    }

    /**
     *
     * @return
     */
    public LocalDateTime getEndDate() {
        return this.date;
    }

    /**
     *
     * @param u
     * @param b
     */
    public void addBet(User u, Bet b) {
        this.bets.add(b);
        this.addObserver(u);
    }

    /**
     *
     * @return
     */
    public List<Bet> getBets() {
        return new ArrayList<>(this.bets);
    }

    /**
     *
     * @return
     */
    public Map<LocalDateTime, Odds> getHistoricOdds() {
        return new TreeMap<>(this.historicOdds);
    }

    @Override
    public String toString() {
        return String.format("ID=%d %s vs %s %s Odds[%s:%f Empate:%f %s:%f] Bookie=%s",
                this.ID,
                this.homeTeam,
                this.awayTeam,
                this.date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")),
                this.homeTeam,
                this.homeOdd,
                this.drawOdd,
                this.awayTeam,
                this.awayOdd,
                this.bookie.getName());
    }

    @Override
    public void addObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(Object o) {
       for (Observer obs : this.observers){
           obs.update(this, o);
       }
    }

    @Override
    public List<Observer> getObservers() {
        return new ArrayList<>(observers);
    }

}
