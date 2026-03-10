package com.cms.gal.dao;

import com.cms.gal.EntityManagerFactoryProvider;
import com.cms.gal.model.Item;

import jakarta.persistence.EntityManager;

public class ItemDao {
    private static EntityManager em = null;

    static {
        em = EntityManagerFactoryProvider.getEntityManager();
    }

    public Item addItem(Item item) {
        em.persist(item);
        return item;
    }
}