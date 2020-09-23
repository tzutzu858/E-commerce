package com.company.store.dao.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.domain.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;

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
        assertEquals("谷歌",customer.getName());
        assertEquals("google",customer.getPassword());
        assertEquals("09123456789",customer.getPhone());
        assertEquals(1111111111,customer.getBirthday().getTime());
    }

    @Test
    void findAll() {
        List<Customer> list = dao.findAll();
        //這是測試總共有幾筆顧客資料
        assertEquals(list.size(),6);
    }

    @Test
    void create() {
        Customer customer = new Customer();
        customer.setId("try1");
        customer.setName("谷歌");
        customer.setPassword("google");
        customer.setPhone("09123456789");
        customer.setBirthday(new Date(1111111111));

        dao.create(customer);

        Customer customer1 = dao.findByPk("google");
        assertEquals("google",customer1.getId());
        assertEquals("谷歌",customer1.getName());
        assertEquals("google",customer1.getPassword());
        assertEquals("09123456789",customer1.getPhone());
        assertEquals(1111111111,customer1.getBirthday().getTime());
    }

    @Test
    void modify() {
        Customer customer = new Customer();

        customer.setId("google");
        customer.setName("估狗");
        customer.setPassword("Google");
        customer.setPhone("1234567890");
        customer.setBirthday(new Date(20200923));

        dao.modify(customer);

        assertEquals("google",customer.getId());
        assertEquals("估狗",customer.getName());
        assertEquals("Google",customer.getPassword());
        assertEquals("1234567890",customer.getPhone());
        assertEquals(20200923,customer.getBirthday().getTime());

    }

    @Test
    void remove() {
        dao.remove("Mayday");

        Customer customer = dao.findByPk("Mayday");

    }
}