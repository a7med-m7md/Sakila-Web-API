package com.iti.services;

import com.iti.persistence.entities.Language;
import com.iti.persistence.repository.BaseRepository;
import com.iti.persistence.repository.LanguageRepository;
import jakarta.persistence.EntityManager;

public class LanguageService extends LanguageRepository<Language> {
    public LanguageService(EntityManager entityManager) {
        super(entityManager);
    }
}
