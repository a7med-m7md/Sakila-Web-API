package com.iti.persistence.repository;

import com.iti.persistence.entities.Store;
import jakarta.persistence.EntityManager;

public class StoreRepository extends BaseRepository<Store>{
    public StoreRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
