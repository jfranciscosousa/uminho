/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josesousa.spotixico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.josesousa.spotixico.models.Artist;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class SpotifyApi {

    private final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private final static String USER_AGENT = "Mozilla/5.0";

    private String clientId;
    private String clientSecret;

    public SpotifyApi(String clientId, String clientSecret) {
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public String getClientId() {
        return clientId;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public List<Artist> getArtistasByName(String name) throws Exception {
        String data = sendGet("https://api.spotify.com/v1/search?q=" + name + "&type=artist");
        List<Artist> artists = new LinkedList<>();
        JsonObject jsonObject = (new JsonParser()).parse(data).getAsJsonObject();
        for (JsonElement artistJson : jsonObject.getAsJsonObject("artists").getAsJsonArray("items")) {
            String artistID = artistJson.getAsJsonObject().get("id").getAsString();
            String artistName = artistJson.getAsJsonObject().get("name").getAsString();
            artists.add(new Artist(artistID, artistName));
        }
        return artists;
    }

    public String getTopSongs(Artist artista) throws Exception {
        JsonObject response = new JsonObject();
        String data = sendGet("https://api.spotify.com/v1/artists/" + artista.getId() + "/top-tracks?country=PT");
        List<String> songs = new LinkedList<>();
        JsonObject jsonObject = (new JsonParser()).parse(data).getAsJsonObject();
        for (JsonElement artistJson : jsonObject.getAsJsonArray("tracks")) {
            String songName = artistJson.getAsJsonObject().get("name").getAsString();
            songs.add(songName);
        }
        response.add("artist", GSON.toJsonTree(artista));
        response.add("tracks", GSON.toJsonTree(songs));
        return GSON.toJson(response);
    }

    private String sendGet(String url) throws Exception {
        url = url.replaceAll(" ", "%20");

        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(url);

        // add request header
        request.addHeader("User-Agent", USER_AGENT);

        HttpResponse response = client.execute(request);

        BufferedReader rd = new BufferedReader(
                new InputStreamReader(response.getEntity().getContent()));

        StringBuilder result = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        return result.toString();

    }
}
