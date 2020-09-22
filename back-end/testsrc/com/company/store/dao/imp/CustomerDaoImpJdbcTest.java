package com.company.store.dao.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerDaoImpJdbcTest {
    CustomerDao dao;
    @BeforeEach
    void setUp() {
        dao = new CustomerDaoImpJdbc();

    }

    @AfterEach
    void tearDown() {
        dao =null;
    }

    @Test
    void findByPk() {
        Customer customer =dao.findByPk("google");

        assertNotNull(customer);
        assertEquals("google",customer.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
        Customer customer = new Customer();
        customer.setId("Mayday");
        customer.setName("五月天");
        customer.setPassword("maydaymayday");
        customer.setPhone("0987654321");
        customer.setBirthday(new Date(1111111111));

        dao.create(customer);

        Customer customer1 = dao.findByPk("Mayday");
        assertEquals("Mayday",customer1.getId());
        assertEquals("五月天",customer1.getName());
        assertEquals("maydaymayday",customer1.getPassword());
        assertEquals("0987654321",customer1.getPhone());
        assertEquals(1111111111,customer1.getBirthday().getTime());
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}