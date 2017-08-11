/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.exceptions.GameAlreadyFinishedException;
import logic.exceptions.GameDoesntExist;
import logic.exceptions.UserNotRegistered;

/**
 *
 * @author joses
 */
public class BetESS {

    //users
    private final Users users;
    //games
    private final Games games;
    //system wide bets
    private final Bets bets;

    /**
     *
     */
    public BetESS() {
        this.users = new Users();
        this.games = new Games();
        this.bets = new Bets();
    }

    /**
     * Regista um utilizador no sistema com as seguintes credenciais
     *
     * @param name
     * @param email
     * @param password
     * @param balance
     */
    public void registerUser(String name, String email, String password, float balance) {
        users.registerUser(name, email, password, balance);
    }

    /**
     * Dado um email e um password, retorna o utilizador caso estas credenciais
     * de acesso sejam válidas
     *
     * @param email
     * @param password
     * @return
     * @throws UserNotRegistered
     */
    public User authenticateUser(String email, String password) throws UserNotRegistered {
        return users.authenticateUser(email, password);
    }

    /**
     * Cria um novo evento, neste caso, um jogo de futebol, com os seguintes
     * parâmetros
     *
     * @param b bookie que criou o jogo
     * @param homeTeam
     * @param awayTeam
     * @param homeOdd
     * @param drawOdd
     * @param awayOdd
     * @param date
     */
    public void newFootballGame(Bookie b, String homeTeam, String awayTeam, float homeOdd, float drawOdd, float awayOdd, LocalDateTime date) {
        Game game = new Game(this.games.getNextId(), Sport.FOOTBALL, b, homeTeam, awayTeam, homeOdd, awayOdd, drawOdd, date);
        this.games.addGame(game);
        b.addGame(game);
    }

    /**
     *
     * @param gameID
     * @param betValue
     * @param result
     * @param useremail
     * @throws GameDoesntExist
     * @throws UserNotRegistered
     */
    public void newFootballBet(int gameID, float betValue, Result result, String useremail) throws GameDoesntExist, UserNotRegistered {
        Game game = this.games.getGame(gameID);
        if (game == null) {
            throw new GameDoesntExist("No game with such ID");
        }
        User user = this.users.getUser(useremail);
        if (user == null) {
            throw new UserNotRegistered("No user with such email");
        }
        user.subtractBalance(betValue);
        float homeOdd = game.getHomeOdd();
        float awayOdd = game.getAwayOdd();
        float drawOdd = game.getDrawOdd();
        int betID = this.bets.getNextId();
        Bet bet = new Bet(game, betID, betValue, result, homeOdd, drawOdd, awayOdd, user);
        this.bets.addBet(bet);
        user.addBet(bet);
        game.addBet(user, bet);
    }

    /**
     *
     * @param gameID
     * @param home
     * @param away
     * @throws GameDoesntExist
     * @throws GameAlreadyFinishedException
     */
    public void setGameScore(int gameID, int home, int away) throws GameDoesntExist, GameAlreadyFinishedException {
        Game game = this.games.getGame(gameID);
        if (game == null) {
            throw new GameDoesntExist("No game with such ID");
        }
        Score s = new Score(home, away);
        game.setScore(s);
    }

    /**
     *
     * @param gameID
     * @param home
     * @param draw
     * @param away
     * @throws GameDoesntExist
     */
    public void setGameOdds(int gameID, float home, float draw, float away) throws GameDoesntExist {
        Game game = this.games.getGame(gameID);
        if (game == null) {
            throw new GameDoesntExist("No game with such ID");
        }
        game.setOdd(new Odds(home, draw, away));
    }

    /**
     *
     * @return
     */
    public List<Bet> getBets() {
        return new ArrayList<>(this.bets.getBets());
    }

    /**
     *
     * @return
     */
    public Collection<Game> getGames() {
        return this.games.getGames();
    }

    /**
     *
     * @param id
     * @return
     * @throws GameDoesntExist
     */
    public Game getGame(int id) throws GameDoesntExist {
        try {
            return this.games.getGame(id);
        } catch (IndexOutOfBoundsException e) {
            throw new GameDoesntExist();
        }
    }

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param balance
     */
    public void registerBookie(String name, String email, String password, float balance) {
        users.registerBookie(name, email, password, balance);
    }

    /**
     *
     * @param predicate
     * @return
     */
    public Collection<Game> searchGames(Predicate<Game> predicate) {
        return this.games.searchGames(predicate);
    }

    /**
     *
     * @param predicate
     * @return
     */
    public Collection<Bet> searchBets(Predicate<Bet> predicate) {
        return this.bets.searchBets(predicate);
    }
}
