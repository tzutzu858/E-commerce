package com.company.store.server;

import com.company.store.domain.Customer;

public interface CustomerService {
    /**
     * 處理使用者登錄
     * @param customer
     * @return 登入成功回傳true,登入失敗回傳false
     */
    boolean login(Customer customer);

    /**
     * 處理使用者註冊
     * @param customer
     * @throws ServiceException 註冊失敗拋出異常
     */
    void register(Customer customer) throws ServiceException;
}
