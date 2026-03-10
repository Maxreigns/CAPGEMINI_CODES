package com.cms.gal.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.cms.gal.EntityManagerFactoryProvider;
import com.cms.gal.model.Parking;

import jakarta.persistence.EntityManager;

public class ParkingDaoTest {

    private static ParkingDao dao = new ParkingDao();
    private static EntityManager em;

    @BeforeClass
    public static void openConnections() {
        em = EntityManagerFactoryProvider.getEntityManager();
    }

    @AfterClass
    public static void closeConnections() {
        if (em != null) {
            em.close();
        }
        EntityManagerFactoryProvider.close();
    }

    @Test
    public void testGetParkingById() {
        Parking parking = dao.getParkingById(100);
        assertNull(parking);
    }

    @Test
    public void testAddParking() {

        Parking parking = new Parking(13, "SlotNo 4");

        em.getTransaction().begin();

        Parking actualParking = dao.addParking(parking);

        em.getTransaction().commit();

        System.out.println("[RECEIVED]: " + actualParking);
        assertNotNull(actualParking);
    }
}