package com.company.store.dao.imp;

import com.company.dbcore.JdbcTemplate;
import com.company.dbcore.PreparedStatementCreator;
import com.company.store.dao.OrderLineItemDao;
import com.company.store.domain.Goods;
import com.company.store.domain.OrderLineItem;
import com.company.store.domain.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderLineItemDaoJdbc implements OrderLineItemDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public OrderLineItem findByPk(long pk) {
        List<OrderLineItem> list = new ArrayList<OrderLineItem>();
        String sql = "select id,goodsid,orderid,quantity,sub_total from OrderLineItems where id =?";

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, pk);
            return ps;
        }, rs -> {
            populate(list, rs);
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<OrderLineItem> findAll() {
        List<OrderLineItem> list = new ArrayList<OrderLineItem>();
        String sql = "select id,goodsid,orderid,quantity,sub_total from OrderLineItems ";

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);

            return ps;
        }, rs -> {
            populate(list, rs);
        });
        return list;
    }

    private void populate(List<OrderLineItem> list, ResultSet rs) throws SQLException {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setId(rs.getLong("id"));
        orderLineItem.setQuantity(rs.getInt("quantity"));
        orderLineItem.setSubTotal(rs.getFloat("sub_total"));
        //???
        Orders orders = new Orders();
        orders.setId(rs.getString("orderid"));
        orderLineItem.setOrders(orders);
        //???
        Goods goods = new Goods();
        goods.setId(rs.getLong("goodsid"));
        orderLineItem.setGoods(goods);

        list.add(orderLineItem);
    }
    @Override
    public void create(OrderLineItem lineItem) {

        String sql = "insert  into OrderLineItems (id,goodsid,orderid,quantity,sub_total) value (?,?,?,?,?)";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, lineItem.getId());
            ps.setLong(2, lineItem.getGoods().getId());
            ps.setString(3, lineItem.getOrders().getId());
            ps.setInt(4, lineItem.getQuantity());
            ps.setDouble(5, lineItem.getSubTotal());

            return ps;
        });
    }

    @Override
    public void modify(OrderLineItem lineItem) {
        String sql = " update OrderLineItems set goodsid=?,orderid=?,quantity=?,sub_total=? where id=?";

        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setLong(1, lineItem.getGoods().getId());
                ps.setString(2, lineItem.getOrders().getId());
                ps.setInt(3, lineItem.getQuantity());
                ps.setDouble(4, lineItem.getSubTotal());
                ps.setLong(5, lineItem.getId());
                return ps;
            }
        });
    }

    @Override
    public void remove(int pk) {
        String sql = "delete from OrderLineItems where id=?";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, pk);
            return ps;
        });
    }
}
