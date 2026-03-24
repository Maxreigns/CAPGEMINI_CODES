package com.gal.dao;

import com.gal.model.Employee;
import org.junit.jupiter.api.*;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoTest {

    static EmployeeDao dao;

    @BeforeAll
    static void setup() {
        dao = new EmployeeDao();
    }
    @Test
    void testGetEmployee() {

        Employee employee = dao.getEmployee(100);

        assertNotNull(employee);
        assertEquals("Steven", employee.getFirst_name());

        System.out.println("Fetched: " + employee);
    }
    @Test
    void testAddMayank() {

        Date hireDate = Date.valueOf("2024-04-05");

        Employee emp = new Employee(
                hireDate,
                50000.0,
                300,   
                200,
                20,
                "6393934300",
                "Mayank",
                "Yadav",
                "Mayank@gmail.com",
                "Software Engineer"
        );

        Employee saved = dao.addEmployee(emp);

        assertNotNull(saved);

        Employee fromDb = dao.getEmployee(300);
        assertEquals("Mayank", fromDb.getFirst_name());

        System.out.println("Inserted: " + fromDb);
    }

    @Test
    void testUpdateMayank() {

        Date hireDate = Date.valueOf("2024-04-05");
        Employee emp = new Employee(
                hireDate,
                50000.0,
                301,   
                200,
                20,
                "6393934300",
                "Mayank",
                "Yadav",
                "Mayank@gmail.com",
                "Software Engineer"
        );

        dao.addEmployee(emp);
        Employee existing = dao.getEmployee(301);
        existing.setSalary(90000);
        existing.setJob_title("Senior Software Engineer");

        dao.updateEmployee(existing);
        Employee updated = dao.getEmployee(301);

        assertEquals(90000, updated.getSalary());
        assertEquals("Senior Software Engineer", updated.getJob_title());

        System.out.println("Updated Successfully: " + updated);
    }
}