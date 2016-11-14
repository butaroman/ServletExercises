package com.roman.buta.config;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    private static final EntityManagerFactory emf = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
        return  Persistence.createEntityManagerFactory("PERSISTENCE_UTIL");
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }

}
