/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jose
 */
public class Bookie extends User{

    private final List<Game> bookmarkedGames;

    /**
     *
     * @param name
     * @param email
     * @param password
     * @param balance
     */
    public Bookie(String name, String email, String password, float balance) {
        super(name, email, password, balance);
        this.bookmarkedGames = new ArrayList<>();
    }

    void addGame(Game game) {
        this.bookmarkedGames.add(game);
    }
}
