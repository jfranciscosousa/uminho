/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author Nuno Oliveira
 */
public class Bet {

    private final Game game;
    private final int betID;
    private final float betValue;
    private final Result result;
    private final float homeOdd;
    private final float drawOdd;
    private final float awayOdd;
    private final User user;
    //true quando aposta está finalizada (utilizador notificado de resultado da aposta)
    private boolean finalized;

    Bet(Game game, int betID, float betValue, Result result, float homeOdd, float drawOdd, float awayOdd, User user) {
        this.game = game;
        this.betID = betID;
        this.betValue = betValue;
        this.result = result;
        this.homeOdd = homeOdd;
        this.drawOdd = drawOdd;
        this.awayOdd = awayOdd;
        this.user = user;
        this.finalized = false;
    }

    /**
     *
     * @return
     */
    public Game getGame() {
        return this.game;
    }

    /**
     *
     * @return
     */
    public int getBetID() {
        return betID;
    }

    /**
     *
     * @return
     */
    public float getBetValue() {
        return betValue;
    }

    /**
     *
     * @return
     */
    public Result getResult() {
        return result;
    }

    /**
     *
     * @return
     */
    public float getHomeOdd() {
        return homeOdd;
    }

    /**
     *
     * @return
     */
    public float getDrawOdd() {
        return drawOdd;
    }

    /**
     *
     * @return
     */
    public float getAwayOdd() {
        return awayOdd;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }

    void setFinalized() {
        this.finalized = true;
    }

    /**
     *
     * @return
     */
    public boolean isFinalized() {
        return this.finalized;
    }

    @Override
    public String toString() {
        return "Bet{" + "gameID=" + game.getID() + ", betID=" + betID + ", betValue=" + betValue + ", result=" + result + ", homeOdd=" + homeOdd + ", drawOdd=" + drawOdd + ", awayOdd=" + awayOdd + ", userID=" + user.getEmail() + '}';
    }

}
