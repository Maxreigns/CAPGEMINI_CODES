package com.cms.gal;

import com.cms.gal.model.Project;
import com.cms.gal.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.sql.Date;
import java.util.Arrays;

public class EntityManagerFactoryProvider {

    private static EntityManagerFactory emf = null;
    private static EntityManager em = null;

    public static void main(String[] args) {

        EntityManager em = getEntityManager();

        em.getTransaction().begin();

        // 1️⃣ Create Employees
        Employee manager = new Employee("Mayank Yadav", 90000.0);
        Employee emp1 = new Employee("Rahul Sharma", 50000.0);
        Employee emp2 = new Employee("Ankit Verma", 55000.0);

        // Persist employees first
        em.persist(manager);
        em.persist(emp1);
        em.persist(emp2);

        // 2️⃣ Create Project
        Project project = new Project(
                Date.valueOf("2026-04-01"),
                Date.valueOf("2027-04-01"),
                "Capgemini",
                20000000.0
        );

        // 3️⃣ Set Manager (OneToOne)
        project.setManager(manager);

        // 4️⃣ Add Employees (ManyToMany)
        project.setEmployees(Arrays.asList(emp1, emp2));

        // 5️⃣ Persist Project
        em.persist(project);

        em.getTransaction().commit();

        System.out.println("Project with Manager and Employees Saved Successfully ✅");

        close();
    }

    public static void close() {

        if (em != null && em.isOpen()) {
            em.close();
        }

        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }

    public static EntityManagerFactory getEntityManagerFactory() {

        if (emf == null || !emf.isOpen()) {
            emf = Persistence.createEntityManagerFactory("company_db_pu");
        }

        return emf;
    }

    public static EntityManager getEntityManager() {

        if (emf == null) getEntityManagerFactory();

        if (em == null || !em.isOpen()) {
            em = emf.createEntityManager();
        }

        return em;
    }
}