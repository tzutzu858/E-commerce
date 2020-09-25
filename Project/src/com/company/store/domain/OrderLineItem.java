package com.company.store.domain;

public class OrderLineItem {

    private long id;
    private int quantity;
    private double sub_Total;
    private Orders orderid;
    private Goods goodsid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getSubTotal() {
        return sub_Total;
    }

    public void setSubTotal(double subTotal) {
        this.sub_Total = subTotal;
    }

    public Orders getOrders() {
        return orderid;
    }

    public void setOrders(Orders orders) {
        this.orderid = orders;
    }

    public Goods getGoods() {
        return goodsid;
    }

    public void setGoods(Goods goods) {
        this.goodsid = goods;
    }
}
