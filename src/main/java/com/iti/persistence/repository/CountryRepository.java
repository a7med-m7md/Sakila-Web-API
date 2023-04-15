package com.iti.persistence.repository;

import com.iti.persistence.entities.Country;
import jakarta.persistence.EntityManager;

public class CountryRepository extends BaseRepository<Country> {
    public CountryRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
