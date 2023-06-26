package com.bbva.practitioner.musicLibrary.repositories;

import java.util.List;
import com.bbva.practitioner.musicLibrary.entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SongsRepository  extends JpaRepository<Song, Integer> {
    @Query(
            value = "SELECT id, title, duration, artists_id FROM song where artists_id='?1'",
            nativeQuery = true
    )

    public List<Song> findByArtist(Integer artistId);

}

// https://localhost:8085/api/v1/songs/?artistName=Pedro;DROP TABLE students;
//SELECT id, title, duration, artists_id FROM song where artist_name='Pedro;DROP TABLE students';