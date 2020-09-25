
package com.company.store.dao.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;


class CustomerDaoImpJdbcTest {
    CustomerDao dao;
    @BeforeEach
    void setUp() {
        dao = new CustomerDaoImpJdbc();
    }

    @AfterEach
    void tearDown() {
        dao = null;
    }

    @Test
    void findByPk() {
        Customer customer = dao.findByPk("facebook");
        assertNotNull(customer);
        assertEquals("facebook",customer.getId());
        assertEquals("奇摩",customer.getName());
        assertEquals("yahoo",customer.getPassword());
        assertEquals("1234567890",customer.getPhone());
        assertEquals(1999999999L,customer.getBirthday().getTime());
    }

    @Test
    void findAll() {
        List<Customer> list = dao.findAll();
        assertEquals(list.size(),1);
    }

    @Test
    void create() {
        Customer customer = new Customer();
        customer.setId("jason");
        customer.setName("傑森");
        customer.setPassword("1234");
        customer.setPhone("11111111");
        customer.setBirthday(new Date(111111112341L));

        dao.create(customer);
        //按照主鍵查詢
        Customer customer1 = dao.findByPk("jason");
        assertEquals("jason",customer1.getId());
        assertEquals("傑森",customer1.getName());
        assertEquals("1234",customer1.getPassword());
        assertEquals("11111111",customer1.getPhone());
        assertEquals(111111112341L,customer1.getBirthday().getTime());

    }

    @Test
    void modify() {
        Customer customer = new Customer();
        customer.setId("jason");
        customer.setName("李四");
        customer.setPassword("567");
        customer.setPhone("56777777");
        customer.setBirthday(new Date(111111112341L));

        dao.modify(customer);
        //按照主鍵查詢
        Customer customer1 = dao.findByPk("jason");
        assertEquals("jason",customer1.getId());
        assertEquals("李四",customer1.getName());
        assertEquals("567",customer1.getPassword());
        assertEquals("56777777",customer1.getPhone());
        assertEquals(111111112341L,customer1.getBirthday().getTime());

    }

    @Test
    void remove() {
        dao.remove("jason");
    }
}