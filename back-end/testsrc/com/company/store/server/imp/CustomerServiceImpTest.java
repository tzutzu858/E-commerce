package com.company.store.server.imp;

import com.company.store.domain.Customer;
import com.company.store.server.CustomerService;
import com.company.store.server.ServiceException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class CustomerServiceImpTest {
    CustomerService customerService;

    @BeforeEach
    void setUp() {
        customerService = new CustomerServiceImp();
    }

    @AfterEach
    void tearDown() {
        customerService = null;
    }

    @Test
    @DisplayName("登入成功")
    void login() {
        Customer customer = new Customer();
        customer.setId("google");
        customer.setPassword("Google");


        assertTrue(customerService.login(customer));
        assertNotNull(customer);
        assertEquals("google", customer.getId());
        assertEquals("估狗", customer.getName());
        assertEquals("Google", customer.getPassword());
        assertEquals("1234567890", customer.getPhone());
        assertEquals(20200923, customer.getBirthday().getTime());
    }

    @Test
    @DisplayName("登入失敗")
    void login2() {

        Customer customer = new Customer();
        customer.setId("google");
        customer.setPassword("google");
        assertFalse(customerService.login(customer));

    }

    @Test
    @DisplayName("成功註冊 會員id不存在")
    void register1() throws ServiceException {
        Customer customer = new Customer();
        customer.setId("tony");
        customer.setName("史塔克");
        customer.setPassword("tony");
        customer.setPhone("1234567890");
        customer.setBirthday(new Date(20200924));

        customerService.register(customer);

        Customer customer1 = new Customer();
        customer1.setId("tony");
        customer1.setPassword("tony");

        customerService.login(customer1);
        assertNotNull(customer1);
        assertEquals("tony", customer1.getId());
        assertEquals("史塔克", customer1.getName());
        assertEquals("tony", customer1.getPassword());
        assertEquals("1234567890", customer1.getPhone());
        assertEquals(20200924, customer1.getBirthday().getTime());
    }

    @Test
    @DisplayName("註冊失敗 id已經存在")
    void register2() throws ServiceException {
        Customer customer1 = new Customer();
        customer1.setId("tony");
        customer1.setPassword("tony");


        assertThrows(ServiceException.class, () -> {
            customerService.register(customer1);
        });


    }
}