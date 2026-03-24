package com.gal.dao;

import com.gal.model.Item;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class ItemDaoTest {

    static ItemDao dao;

    @BeforeAll
    static void setup() {
        dao = new ItemDao();
    }

    @Test
    void testAddItem() {

        Item item = new Item("Electronics", "Laptop", 55000);

        Item saved = dao.addItem(item);

        assertNotNull(saved.getItemId());

        System.out.println("Inserted: " + saved);
    }
}