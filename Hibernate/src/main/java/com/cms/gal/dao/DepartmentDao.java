package com.cms.gal.dao;

import com.cms.gal.EntityManagerFactoryProvider;
import com.cms.gal.model.Department;

import jakarta.persistence.EntityManager;

public class DepartmentDao {
    private static EntityManager em = null;

    static {
        em = EntityManagerFactoryProvider.getEntityManager();
    }

    public Department getDepartmentById(int deptId) {
        Department department = em.find(Department.class, deptId);
        return department;
    }
}