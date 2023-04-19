package com.iti.persistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAFactoryManager {
    private final static EntityManagerFactory entityManagerFactory;
    private static final ThreadLocal<EntityManager> ENTITY_MANAGER_THREAD_LOCAL = new ThreadLocal<>();
    static {
        entityManagerFactory = Persistence.createEntityManagerFactory("rest");
    }

    public static EntityManager createEntityManager(){
        EntityManager entityManager = ENTITY_MANAGER_THREAD_LOCAL.get();
        if(entityManager == null){
            entityManager = entityManagerFactory.createEntityManager();
            ENTITY_MANAGER_THREAD_LOCAL.set(entityManager);
        }
        return entityManager;
    }

    public static void closeEntityManager(){
        EntityManager entityManager = ENTITY_MANAGER_THREAD_LOCAL.get();
//        ENTITY_MANAGER_THREAD_LOCAL.set(null);
        if(entityManager != null){
            ENTITY_MANAGER_THREAD_LOCAL.set(null);
            entityManager.close();
        }
    }


    public static void closeEntityManagerFactory(){
        entityManagerFactory.close();
    }
}
