package com.company.store.service.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.dao.imp.CustomerDaoImpJdbc;
import com.company.store.domain.Customer;
import com.company.store.service.CustomerService;
import com.company.store.service.ServiceException;

public class CustomerServiceImp implements CustomerService {
    CustomerDao customerDao = new CustomerDaoImpJdbc();

    @Override
    public boolean login(Customer customer) {

        Customer dbCustomer = customerDao.findByPk(customer.getId());

        if (dbCustomer != null &&
                dbCustomer.getPassword().equals(customer.getPassword())) {

            // 把db返回的客户信息返回给表示層
            customer.setName(dbCustomer.getName());
            customer.setBirthday(dbCustomer.getBirthday());
            customer.setPhone(dbCustomer.getPhone());

            return true;
        }

        return false;
    }

    @Override
    public void register(Customer customer) throws ServiceException {

        Customer dbCustomer = customerDao.findByPk(customer.getId());

        if (dbCustomer != null) { //客户ID已经存在了
            throw new ServiceException("客户ID: " + customer.getId() + "已經存在！");
        }

        // 註冊開始
        customerDao.create(customer);
    }
}
