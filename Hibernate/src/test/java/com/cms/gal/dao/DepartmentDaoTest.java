package com.cms.gal.dao;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import com.cms.gal.EntityManagerFactoryProvider;
import com.cms.gal.model.Department;

class DepartmentDaoTest {
    private static DepartmentDao dao = new DepartmentDao();

    @AfterAll
    public static void closeConnections() {
        EntityManagerFactoryProvider.close();
    }

    @Test
    void testGetDepartmentById() {
        Department department = dao.getDepartmentById(30);

        assertNotNull(department);
        System.out.println("[RECIEVED]: " + department);
        assertEquals("Sales", department.getDepartmentName());
    }
}