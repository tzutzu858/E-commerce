package com.company.store.domain;


import java.util.Date;

public class Orders {

    private String id;
    private Date orderDate;
    /*訂單狀態 1代表待確認 0代表已確認*/
    private int status = 1;
    private double total;
}
