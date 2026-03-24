package com.cap.main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntityManagerFactoryProvider {

private static EntityManagerFactory emf =
Persistence.createEntityManagerFactory("training_capg_pu");

public static EntityManager getEntityManager() {
return emf.createEntityManager();
}

public static void close() {
emf.close();
}

}