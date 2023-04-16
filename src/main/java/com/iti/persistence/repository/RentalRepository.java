package com.iti.persistence.repository;

import com.iti.persistence.entities.Rental;
import jakarta.persistence.EntityManager;

public class RentalRepository extends BaseRepository<Rental>{
    public RentalRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
