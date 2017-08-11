/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic.predicates;

import com.google.common.base.Predicate;
import logic.Bet;
import logic.Game;

/**
 *
 * @author jose
 */
public class BetPredicates {

    private BetPredicates() {

    }

    /**
     * Predicado que dá match com todas as apostas cujos jogos dêm match com um
     * determinado GamePredicate
     */
    static public class GamePredicate implements Predicate<Bet> {

        private final Predicate<Game> gameP;

        /**
         *
         * @param gameP
         */
        public GamePredicate(Predicate<Game> gameP) {
            this.gameP = gameP;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return this.gameP.apply(t.getGame());
        }
    }

    /**
     * Predicado que dá match com todas as apostas com um determinado valor
     */
    static public class ValueEqualPredicate implements Predicate<Bet> {

        private final float value;

        /**
         *
         * @param value
         */
        public ValueEqualPredicate(float value) {
            this.value = value;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return this.value == t.getBetValue();
        }

    }

    /**
     * Predicado que dá match com todas as apostas maiores ou iguais a um
     * determinado valor
     */
    static public class ValueGreaterPredicate implements Predicate<Bet> {

        private final float value;

        /**
         *
         * @param value
         */
        public ValueGreaterPredicate(float value) {
            this.value = value;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return t.getBetValue() >= this.value;
        }

    }

    /**
     * Predicado que dá match com apostas menores ou iguais a um determinado
     * valor
     */
    static public class ValueLessPredicate implements Predicate<Bet> {

        private final float value;

        /**
         *
         * @param value
         */
        public ValueLessPredicate(float value) {
            this.value = value;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return t.getBetValue() <= this.value;
        }

    }

    /**
     * Predicado que dá match com as apostas de um determinado utilizador
     */
    static public class UserPredicate implements Predicate<Bet> {

        private final String user;

        /**
         *
         * @param user
         */
        public UserPredicate(String user) {
            this.user = user;
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return t.getUser().equals(this.user);
        }

    }

    /**
     * Predicado que dá match com as apostas finalizadas
     */
    static public class FinalizedPredicate implements Predicate<Bet> {

        /**
         *
         * @param user
         */
        public FinalizedPredicate() {
        }

        /**
         *
         * @param t
         * @return
         */
        @Override
        public boolean apply(Bet t) {
            return t.isFinalized();
        }

    }

}
