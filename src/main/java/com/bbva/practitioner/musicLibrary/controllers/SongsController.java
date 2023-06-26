package com.bbva.practitioner.musicLibrary.controllers;


import com.bbva.practitioner.musicLibrary.entities.Artist;
import com.bbva.practitioner.musicLibrary.entities.Song;
import com.bbva.practitioner.musicLibrary.repositories.ArtistsRepository;
import com.bbva.practitioner.musicLibrary.repositories.SongsRepository;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/songs")
public class SongsController {
    private SongsRepository repository;

    public SongsController(SongsRepository repository) {
        this.repository = repository;
    }
    // Leer
    // https://localhost:8085/api/v1/songs/?artist=1
    @GetMapping
    public List<Song> list(@RequestParam(name = "artist", required = false) String artistId) {
        if(artistId == null) {
            return this.repository.findAll();
        } else {
            return  this.repository.findByArtist(artistId);
        }
    }

    // Crear
    @PostMapping
    public Song create(@RequestBody Song song) {
        return this.repository.save(song);
    }

    // Editar
    // /books/1/
    //  {
    //      title: sasda
    //
    // }
    @PutMapping("/{id}")
    public Song edit(@PathParam("id") Integer songId, @RequestBody Song modifiedSong) {

        Optional<Song> s = this.repository.findById(songId);
        if(s.isEmpty()) throw new RuntimeException("404 Not Found");
        else {
            Song song = s.get();
            song.setTitle(modifiedSong.getTitle());
            song.setDuration(modifiedSong.getDuration());
            return this.repository.save(song);
        }

    }

    // Delete
    @DeleteMapping("/{id}")
    public Song delete(@PathParam("id") Integer id) {
        Optional<Song> song = this.repository.findById(id);
        if(song.isEmpty()) throw new RuntimeException("404 Not Found");
        this.repository.delete(song.get());
        return song.get();
    }
}
