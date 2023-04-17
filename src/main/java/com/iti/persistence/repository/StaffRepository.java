package com.iti.persistence.repository;

import com.iti.persistence.entities.Staff;
import jakarta.persistence.EntityManager;

public class StaffRepository extends BaseRepository<Staff>{
    public StaffRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
