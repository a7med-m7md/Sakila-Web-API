package com.iti.persistence.repository;

import com.iti.persistence.entities.Film;
import jakarta.persistence.EntityManager;

public class FilmRepository extends BaseRepository<Film>{
    public FilmRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
