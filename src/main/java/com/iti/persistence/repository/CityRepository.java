package com.iti.persistence.repository;

import com.iti.persistence.entities.City;
import jakarta.persistence.EntityManager;

public class CityRepository<T> extends BaseRepository<City> {
    protected CityRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
