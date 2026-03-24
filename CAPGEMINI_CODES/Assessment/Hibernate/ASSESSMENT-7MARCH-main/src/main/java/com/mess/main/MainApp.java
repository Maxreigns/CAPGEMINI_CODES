package com.mess.main;

import com.mess.entity.*;
import jakarta.persistence.*;

import java.util.List;

public class MainApp {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("messPU");

        EntityManager em = emf.createEntityManager();


        em.getTransaction().begin();

        Supplier s = new Supplier("Ram Traders", "Delhi", 5);
        Item i = new Item("Rice");

        em.persist(s);
        em.persist(i);

        Supply sp = new Supply(s, i);
        em.persist(sp);

        em.getTransaction().commit();

        System.out.println("Data Inserted Successfully\n");


        // 1
        System.out.println("---- All Supplier Names ----");

        List<String> suppliers =
                em.createQuery(
                                "SELECT s.sname FROM Supplier s",
                                String.class)
                        .getResultList();

        suppliers.forEach(System.out::println);


        // 2
        System.out.println("\n---- Suppliers from Delhi ----");

        List<Supplier> delhi =
                em.createQuery(
                                "SELECT s FROM Supplier s WHERE s.city='Delhi'",
                                Supplier.class)
                        .getResultList();

        delhi.forEach(sup ->
                System.out.println(
                        sup.getSid() + " " +
                                sup.getSname() + " " +
                                sup.getCity()
                )
        );


        // 3
        System.out.println("\n---- Items supplied by Supplier 1 ----");

        List<String> items =
                em.createQuery(
                                "SELECT i.name FROM Supply sp JOIN sp.item i WHERE sp.supplier.sid=1",
                                String.class)
                        .getResultList();

        items.forEach(System.out::println);


        em.close();
        emf.close();
    }
}