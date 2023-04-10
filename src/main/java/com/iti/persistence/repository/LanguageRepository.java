package com.iti.persistence.repository;

import com.iti.persistence.entities.Language;
import jakarta.persistence.EntityManager;

public class LanguageRepository<T> extends BaseRepository<Language> {
    protected LanguageRepository(EntityManager entityManager) {
        super(entityManager);
    }
}
