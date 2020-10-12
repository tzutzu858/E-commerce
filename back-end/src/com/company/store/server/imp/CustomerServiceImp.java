package com.company.store.server.imp;

import com.company.store.dao.CustomerDao;
import com.company.store.dao.imp.CustomerDaoImpJdbc;
import com.company.store.domain.Customer;
import com.company.store.server.CustomerService;
import com.company.store.server.ServiceException;

public class CustomerServiceImp implements CustomerService {
    //從資料庫撈資料去跟表示層的資料做比對
    CustomerDao customerDao = new CustomerDaoImpJdbc();

    @Override
    public boolean login(Customer customer) {
        //表示層會先取的使用者輸入的id及密碼
        Customer dbCustomer = customerDao.findByPk(customer.getId());

        if (dbCustomer != null &&
            dbCustomer.getPassword().equals(customer.getPassword())) {
            //登入成功
            customer.setPhone(dbCustomer.getPhone());
            customer.setName(dbCustomer.getName());
            customer.setBirthday(dbCustomer.getBirthday());
            return true;
        }

        return false;
    }

    @Override
    public void register(Customer customer) throws ServiceException {
        Customer dbCustomer = customerDao.findByPk(customer.getId());
        if (dbCustomer != null) {//使用者帳號已經存在
            throw new ServiceException("使用者帳號" + customer.getId() + "已經存在!");
        }
        //開始註冊
        customerDao.create(customer);
    }
}
