package com.iti.persistence.repository;

import com.iti.persistence.entities.Customer;
import jakarta.persistence.EntityManager;

public class CustomerRepository<T> extends BaseRepository<Customer>{
    public CustomerRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
