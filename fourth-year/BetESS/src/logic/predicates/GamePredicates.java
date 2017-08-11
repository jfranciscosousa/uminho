/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.predicates;

import com.google.common.base.Predicate;
import java.time.Month;
import logic.Game;
import logic.Result;

/**
 * This class contains subclasses that implement Predicate<Game>
 * These classes should be used to filter games on the app (Filter Design
 * Pattern)
 *
 * @author jose
 */
public class GamePredicates {

    private GamePredicates() {

    }

    /**
     * This predicate will match with any game that was created by a specific
     * bookie
     */
    static public class BookiePredicate implements Predicate<Game> {

        private final String user;

        /**
         *
         * @param user
         */
        public BookiePredicate(String user) {
            this.user = user;
        }

        /**
         *
         * @param g
         * @return
         */
        @Override
        public boolean apply(Game g) {
            return g.getBookie().getEmail().equals(user);
        }

    }

    /**
     * This predicate will match with any games that have a specific home team
     */
    static public class HomeTeamPredicate implements Predicate<Game> {

        private final String team;

        /**
         *
         * @param team
         */
        public HomeTeamPredicate(String team) {
            this.team = team;
        }

        /**
         *
         * @param g
         * @return
         */
        @Override
        public boolean apply(Game g) {
            return g.getHomeTeam().equals(team);
        }
    }

    /**
     * This predicate will match with any games that have a specific away team
     */
    static public class AwayTeamPredicate implements Predicate<Game> {

        private final String team;

        /**
         *
         * @param team
         */
        public AwayTeamPredicate(String team) {
            this.team = team;
        }

        /**
         *
         * @param g
         * @return
         */
        @Override
        public boolean apply(Game g) {
            return g.getAwayTeam().equals(team);
        }
    }

    /**
     * This predicate will match with any games that are played on a specific
     * month
     */
    static public class MonthPredicate implements Predicate<Game> {

        private final Month month;

        /**
         *
         * @param month
         */
        public MonthPredicate(Month month) {
            this.month = month;
        }

        /**
         *
         * @param g
         * @return
         */
        @Override
        public boolean apply(Game g) {
            return g.getEndDate().getMonth().equals(this.month);
        }
    }

    /**
     * This predicate will match with any games that already ended
     */
    static public class FinishedPredicate implements Predicate<Game> {

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Game t) {
            return t.isFinished();
        }
    }

    /**
     * This predicate will match any games that ended with a specific result
     */
    static public class ResultPredicate implements Predicate<Game> {

        private final Result result;

        /**
         *
         * @param result
         */
        public ResultPredicate(Result result) {
            this.result = result;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Game t) {
            return t.isFinished() && t.getScore().getResult().equals(result);
        }
    }
}
