/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author joses
 */
public class Score {

    private final int home;
    private final int away;
    private final Result result;

    Score(int home, int away) {
        this.home = home;
        this.away = away;
        if (home == away) {
            this.result = Result.DRAW;
        } else if (home > away) {
            this.result = Result.HOME;
        } else if (home < 0 || away < 0) {
            this.result = Result.ONGOING;
        } else {
            this.result = Result.AWAY;
        }
    }

    /**
     *
     * @return
     */
    public int getHome() {
        return home;
    }

    /**
     *
     * @return
     */
    public int getAway() {
        return away;
    }

    /**
     *
     * @return
     */
    public Result getResult() {
        return result;
    }

    @Override
    public String toString() {
        return "Score{" + "home=" + home + ", away=" + away + ", result=" + result + '}';
    }

}
