package com.iti.persistence.repository;

import com.iti.persistence.entities.Film;
import jakarta.persistence.EntityManager;

public class FilmRepository<T> extends BaseRepository<Film>{
    protected FilmRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
