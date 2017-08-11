/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josesousa.spotixico.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.josesousa.spotixico.SpotifyApi;
import com.josesousa.spotixico.models.Artist;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jose
 */
@RestController
public class DefaultController {
    
    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Autowired
    private SpotifyApi spotifyApi;

    @RequestMapping(path = "/api/toptracks", method = RequestMethod.GET)
    String songs(@RequestParam("artist") String artist) throws Exception {
        List<Artist> artists = this.spotifyApi.getArtistasByName(artist);
        return GSON.toJson(this.spotifyApi.getTopSongs(artists.get(0)));
    }
    
}
