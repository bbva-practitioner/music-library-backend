package com.bbva.practitioner.musicLibrary.entities;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

@Entity
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NonNull
    private String firstName;

    private String lastName;

    public Artist() {};

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return  lastName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
