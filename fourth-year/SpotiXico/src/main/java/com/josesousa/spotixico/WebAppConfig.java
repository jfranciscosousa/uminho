/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.josesousa.spotixico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author jose
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class WebAppConfig{

    public static void main(String args[]) throws Exception {
        SpringApplication.run(WebAppConfig.class, args);
    }

    @Bean
    public SpotifyApi spotifyApiBean() {
        String clientId = "ca936d28e15342ff97b8cb369a474654";
        String clientSecret = "da6808507b42496db8a36b360c31f9ab";
        return new SpotifyApi(clientId, clientSecret);
    }
}
