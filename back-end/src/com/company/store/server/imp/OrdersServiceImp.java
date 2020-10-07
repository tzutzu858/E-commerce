package com.company.store.server.imp;

import com.company.store.dao.GoodsDao;
import com.company.store.dao.OrderDao;
import com.company.store.dao.OrderLineItemDao;
import com.company.store.dao.imp.GoodsDaoImpJdbc;
import com.company.store.dao.imp.OrderDaoImpJdbc;
import com.company.store.dao.imp.OrderLineItemDaoJdbc;
import com.company.store.domain.Goods;
import com.company.store.domain.OrderLineItem;
import com.company.store.domain.Orders;
import com.company.store.server.OrdersService;

import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrdersServiceImp implements OrdersService {

    GoodsDao goodsDao = new GoodsDaoImpJdbc();
    OrderDao orderDao = new OrderDaoImpJdbc();
    OrderLineItemDao orderLineItemDao = new OrderLineItemDaoJdbc();


    @Override
    public String submitOrders(List<Map<String, Object>> cart) {
        Orders orders = new Orders();
        Date date = new Date();
        //訂單編號＝目前時間標記+亂數（避免重複）
        //大型電商有很多會員 ，同時下訂單只用時間標記做訂單編號很容易重複
        String ordersid = String.valueOf(date.getTime()) + String.valueOf((int) (Math.random() * 100));

        orders.setId(ordersid);
        orders.setOrderDate(date);
        orders.setStatus(1);
        //訂單金額是在購物車裡做計算的，先給0當初始值
        orders.setTotal(0.0f);

        orderDao.create(orders);

        double total = 0.0;
        //購物車運算
        for (Map item : cart) {
            //item結構[商品id , 數量]

            //取得key為"goodsid"的value 並轉換為 long
            Long goodsid = (Long) (item.get("goodsid"));
            //取得key為"quantity"的value 並轉換為Integer
            Integer quantity = (Integer) (item.get("quantity"));
            //用goodsid 取得good
            Goods goods = goodsDao.findByPk(goodsid);
            //小計
            double subtotal = quantity * goods.getPrice();
            total += subtotal;

            OrderLineItem orderLineItem = new OrderLineItem();
            orderLineItem.setQuantity(quantity);
            orderLineItem.setGoods(goods);
            orderLineItem.setOrders(orders);
            orderLineItem.setSubTotal(subtotal);

            //將訂單詳情插入資料庫
            orderLineItemDao.create(orderLineItem);
        }
        orders.setTotal(total);
        orderDao.modify(orders);
        return ordersid;
    }
}
//功能 提交訂單
//(一、設定訂單內容)
//1.設定orderid
//2.設定訂單日期
//3.訂單狀態
//4.計算訂單總金額 同時將訂單詳情插入資料庫