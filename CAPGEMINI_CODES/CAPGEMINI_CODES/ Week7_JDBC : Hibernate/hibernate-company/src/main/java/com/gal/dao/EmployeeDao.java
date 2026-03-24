package com.gal.dao;

import com.gal.model.Employee;
import com.gal.hibernate_company.EntityManagerFactoryProvider;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class EmployeeDao {

    public Employee getEmployee(int id) {

        EntityManager em =
                EntityManagerFactoryProvider.getEntityManager();

        Employee employee = em.find(Employee.class, id);

        em.close();

        return employee;
    }

    public Employee addEmployee(Employee emp) {

        EntityManager em =
                EntityManagerFactoryProvider.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(emp);
            tx.commit();
            return emp;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }

    public Employee updateEmployee(Employee emp) {

        EntityManager em =
                EntityManagerFactoryProvider.getEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            Employee updated = em.merge(emp);  
            tx.commit();
            return updated;

        } catch (Exception e) {

            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;

        } finally {
            em.close();
        }
    }
}