package com.company.store.dao.imp;

import com.company.dbcore.JdbcTemplate;
import com.company.dbcore.PreparedStatementCreator;
import com.company.store.dao.OrderDao;
import com.company.store.domain.Orders;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderDaoImpJdbc implements OrderDao {

    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Orders findByPk(String pk) {
        List<Orders> list = new ArrayList<Orders>();
        String sql = "select id,order_date,status,total from Orders where id=?";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, pk);
            return ps;
        }, rs -> {
            popluate(list, rs);
        });

        if (list.size() == 1) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public List<Orders> findAll() {

        List<Orders> list = new ArrayList<Orders>();
        String sql = "select id,order_date,status,total from Orders";
        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        }, rs -> {
            popluate(list, rs);
        });
        return list;
    }

    private void popluate(List<Orders> list, ResultSet rs) throws SQLException {
        Orders orders = new Orders();
        orders.setId(rs.getString("id"));
        orders.setOrderDate(new Date(rs.getLong("order_date")));
        orders.setStatus(rs.getInt("status"));
        orders.setTotal(rs.getDouble("total"));

        list.add(orders);
    }

    @Override
    public void create(Orders orders) {
        String sql = "insert into Orders (id,order_date,status,total)  values (?,?,?,?) ";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, orders.getId());
            ps.setLong(2, orders.getOrderDate().getTime());
            ps.setInt(3, orders.getStatus());
            ps.setDouble(4, orders.getTotal());
            return ps;
        });
    }

    @Override
    public void modify(Orders orders) {
        String sql = "update Orders set order_date=? ,status=? ,total=? where id = ? ";
        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, orders.getOrderDate().getTime());
            ps.setInt(2, orders.getStatus());
            ps.setDouble(3, orders.getTotal());
            ps.setString(4, orders.getId());
            return ps;
        });
    }

    @Override
    public void remove(String pk) {
        String sql = "delete from Orders where id = ?";
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, pk);
                return ps;
            }
        });
    }
}
