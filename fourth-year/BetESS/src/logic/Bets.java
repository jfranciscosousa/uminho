/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jose
 */
class Bets {

    private final Map<Integer, Bet> bets;

    public Bets() {
        this.bets = new HashMap<>();
    }

    void addBet(Bet bet) {
        int id = this.bets.size() + 1;
        this.bets.put(id, bet);
    }

    Bet getBet(int id) {
        return this.bets.get(id);
    }

    int getNextId() {
        return this.bets.size() + 1;
    }

    Collection<Bet> getBets() {
        return new ArrayList<>(this.bets.values());
    }

    Collection<Bet> searchBets(Predicate<Bet> predicate) {
        return Collections2.filter(this.bets.values(), predicate);
    }
}
