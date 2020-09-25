package com.company.store.service.imp;

import com.company.store.domain.Customer;
import com.company.store.service.CustomerService;
import com.company.store.service.ServiceException;
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
    void login1() {
        Customer customer = new Customer();
        customer.setId("jason");
        customer.setPassword("1234");

        assertTrue(customerService.login(customer));
        assertNotNull(customer);
        assertEquals("jason", customer.getId());
        assertEquals("傑森", customer.getName());
        assertEquals("1234", customer.getPassword());
        assertEquals("11111111", customer.getPhone());
        assertEquals(111111112341L, customer.getBirthday().getTime());
    }

    @Test
    @DisplayName("登入失敗")
    void login2() {

        Customer customer = new Customer();
        customer.setId("jason");
        customer.setPassword("123");
        assertFalse(customerService.login(customer));

    }

    @Test
    @DisplayName("註冊成功")
    void register1() throws ServiceException {
        Customer customer = new Customer();
        customer.setId("tina");
        customer.setName("惠");
        customer.setPassword("1234");
        customer.setPhone("09");
        customer.setBirthday(new Date(1015L));

        customerService.register(customer);

        Customer customer1 = new Customer();
        customer1.setId("tina");
        customer1.setPassword("1234");

        customerService.login(customer1);
        assertNotNull(customer1);
        assertEquals("tina", customer1.getId());
        assertEquals("惠", customer1.getName());
        assertEquals("1234", customer1.getPassword());
        assertEquals("09", customer1.getPhone());
        assertEquals(1015L, customer1.getBirthday().getTime());

    }

    @Test
    @DisplayName("ID已經存在")
    void register2() {

        Customer customer = new Customer();
        customer.setId("tina");
        customer.setPassword("1234");

        assertThrows(ServiceException.class, () -> {
            customerService.register(customer);
        });

    }

}