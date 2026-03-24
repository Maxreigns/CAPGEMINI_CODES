package com.cap.main;

import jakarta.persistence.EntityManager;


import com.cap.model.*;

public class MainTrainingApp {

public static void main(String[] args) {

EntityManager em =
EntityManagerFactoryProvider.getEntityManager();

em.getTransaction().begin();

Trainer t1 = new Trainer("Dinesh Kumar","TestYantra","Java");
Trainer t2 = new Trainer("Sanjay Kumar","TestYantra","Cloud");

em.persist(t1);
em.persist(t2);

Batch b1 = new Batch();
b1.setName("Java Batch");

em.persist(b1);

TopicTeaching tt1 = new TopicTeaching();
tt1.trainer=t1;
tt1.setBatch(b1);
tt1.setTopics("Java");

em.persist(tt1);

em.getTransaction().commit();

em.close();

EntityManagerFactoryProvider.close();

System.out.println("Data inserted successfully");

}

}