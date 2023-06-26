package com.bbva.practitioner.musicLibrary.controllers;

import com.bbva.practitioner.musicLibrary.entities.Artist;
import com.bbva.practitioner.musicLibrary.repositories.ArtistsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artists")
public class ArtistsController {

    private ArtistsRepository repository;

    public ArtistsController(ArtistsRepository repository) {
        this.repository = repository;
    }
    // Leer
    @GetMapping
    public List<Artist> list() {
        return this.repository.findAll();
    }

    // Crear
    @PostMapping
    public Artist create(@RequestBody Artist artist) {
        return this.repository.save(artist);
    }

}
