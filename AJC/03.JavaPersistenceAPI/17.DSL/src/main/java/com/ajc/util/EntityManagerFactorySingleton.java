package com.ajc.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactorySingleton {
    private static EntityManagerFactorySingleton instance;
    private EntityManagerFactory entityManagerFactory;

    private EntityManagerFactorySingleton(){
        entityManagerFactory = Persistence.createEntityManagerFactory("music");
    }

    public static EntityManagerFactorySingleton getInstance(){
        if (instance == null){
            instance = new EntityManagerFactorySingleton();
        }
        return instance;
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

}
