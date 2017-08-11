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
class Games {

    private final Map<Integer, Game> games;

    Games() {
        this.games = new HashMap<>();
    }

    void addGame(Game game) {
        int id = this.games.size() + 1;
        this.games.put(id, game);
    }

    Game getGame(int id) {
        return this.games.get(id);
    }
    
    int getNextId(){
        return this.games.size()+1;
    }

    Collection<Game> getGames(){
        return new ArrayList<>(this.games.values());
    }
    
    Collection<Game> searchGames(Predicate<Game> predicate) {
        return Collections2.filter(this.games.values(), predicate);
    }
}
