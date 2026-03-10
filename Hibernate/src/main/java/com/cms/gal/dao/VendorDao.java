package com.cms.gal.dao;

import com.cms.gal.EntityManagerFactoryProvider;
import com.cms.gal.model.Vendor;

import jakarta.persistence.EntityManager;

public class VendorDao {
    private static EntityManager em = null;

    static {
        em = EntityManagerFactoryProvider.getEntityManager();
    }

    public Vendor addVendor(Vendor vendor) {
        em.persist(vendor);
        return vendor;
    }
}