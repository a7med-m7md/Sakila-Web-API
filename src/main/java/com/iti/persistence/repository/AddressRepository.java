package com.iti.persistence.repository;

import com.iti.persistence.entities.Address;
import jakarta.persistence.EntityManager;

public class AddressRepository extends BaseRepository<Address> {
    public AddressRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
