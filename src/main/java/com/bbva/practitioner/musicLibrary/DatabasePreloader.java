package com.bbva.practitioner.musicLibrary;

import com.bbva.practitioner.musicLibrary.entities.Artist;
import com.bbva.practitioner.musicLibrary.entities.Song;
import com.bbva.practitioner.musicLibrary.repositories.ArtistsRepository;
import com.bbva.practitioner.musicLibrary.repositories.SongsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatabasePreloader {

    @Bean
    CommandLineRunner preloadDatabase(SongsRepository songs, ArtistsRepository artists) {
        return (args) -> {
            Artist miranda = new Artist("Miranda", null);
            artists.save(miranda);

            Song don = new Song("Don", 2134, miranda);
            songs.save(don);
        };

    }
}
