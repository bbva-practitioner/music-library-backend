package com.bbva.practitioner.musicLibrary.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String title;

    @NonNull
    private Integer duration;

    @OneToOne
    @JoinColumn(name="artists_id")
    private Artist artist;

    public Song() {};

    public Song(String title, Integer duration, Artist artist) {
        this.title = title;
        this.duration = duration;
        this.artist = artist;
    }

    @NonNull
    public String getTitle() {
        return title;
    }

    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

}
