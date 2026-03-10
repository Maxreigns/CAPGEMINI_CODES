package com.gal;

import com.gal.model.Customer;

import jakarta.persistence.EntityManager;

public class Main {

    public static void main(String[] args) {
        EntityManager em = EntityManagerFactoryProvider.getEntityManager();
        Customer customer = em.find(Customer.class, 101);

        em.getTransaction().begin();
        Customer c = new Customer();
        em.persist(c);

        em.getTransaction().commit();

    }

}