package com.iti.persistence.repository;

import com.iti.persistence.entities.Inventory;
import jakarta.persistence.EntityManager;

public class InventoryRepository extends BaseRepository<Inventory> {
    public InventoryRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
