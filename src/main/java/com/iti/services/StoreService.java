package com.iti.services;

import com.iti.persistence.repository.StoreRepository;
import jakarta.persistence.EntityManager;

public class StoreService extends StoreRepository {
    public StoreService(EntityManager entityManager) {
        super(entityManager);
    }
}
