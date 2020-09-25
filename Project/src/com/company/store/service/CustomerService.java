package com.company.store.service;

import com.company.store.domain.Customer;

public interface CustomerService {
    /**
     * 處理客戶登入
     * @param customer
     * @return 登入成功返回true,登入失敗返回false
     */
    boolean login(Customer customer);

    /**
     *處理客戶註冊
     * @param customer
     * @throws ServiceException 注册失败抛出异常
     */
    void register(Customer customer) throws ServiceException;
}
