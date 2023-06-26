package com.bbva.practitioner.musicLibrary.repositories;

import com.bbva.practitioner.musicLibrary.entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistsRepository extends JpaRepository<Artist, Integer> {}

