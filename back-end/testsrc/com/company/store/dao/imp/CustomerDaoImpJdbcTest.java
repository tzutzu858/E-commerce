package com.company.store.dao.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}