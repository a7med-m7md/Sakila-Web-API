package com.iti.persistence.repository;

import com.iti.persistence.entities.Payment;
import jakarta.persistence.EntityManager;

public class PaymentRepository extends BaseRepository<Payment>{
    public PaymentRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
