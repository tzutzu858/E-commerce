package com.company.store.dao.imp;

import com.company.dbcore.JdbcTemplate;
import com.company.store.dao.GoodsDao;
import com.company.store.domain.Goods;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDaoImpJdbc implements GoodsDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate();

    @Override
    public Goods findByPk(long pk) {
        List<Goods> list = new ArrayList<Goods>();
        String sql = "select id,name,price,description,image from Goods where id =?";

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
    public List<Goods> findAll() {
        List<Goods> list = new ArrayList<Goods>();
        String sql = "select id,name,price,description,image from Goods";

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            return ps;
        }, rs -> {
            populate(list, rs);
        });
        return list;
    }

    @Override
    public List<Goods> findStartEnd(int start, int end) {
        List<Goods> list = new ArrayList<Goods>();

        StringBuffer sql = new StringBuffer("select id,name,price,description,image from Goods");
        sql.append(" limit ").append(end - start);  //這三小？
        sql.append(" offset ").append(start);

        jdbcTemplate.query(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql.toString());
            return ps;
        }, rs -> {
            populate(list, rs);
        });

        return list;
    }

    private void populate(List<Goods> list, ResultSet rs) throws SQLException {
        Goods goods = new Goods();
        goods.setId(rs.getLong("id"));
        goods.setName(rs.getString("name"));
        goods.setPrice(rs.getDouble("price"));
        goods.setDescription(rs.getString("description"));
        goods.setImage(rs.getString("image"));

        list.add(goods);
    }

    @Override
    public void create(Goods goods) {
        String sql = "insert into Goods (id,name,price,description,image)" +
                " value (?,?,?,?,?)";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setLong(1, goods.getId());
            ps.setString(2, goods.getName());
            ps.setDouble(3, goods.getPrice());
            ps.setString(4, goods.getDescription());
            ps.setString(5, goods.getImage());

            return ps;
        });
    }

    @Override
    public void modify(Goods goods) {
        String sql = "update Goods set name=?,price=?,description=?,image=? where id =? ";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, goods.getName());
            ps.setDouble(2, goods.getPrice());
            ps.setString(3, goods.getDescription());
            ps.setString(4, goods.getImage());
            ps.setLong(5, goods.getId());

            return ps;
        });
    }

    @Override
    public void remove(long pk) {
        String sql = "delete from Goods where id =? ";

        jdbcTemplate.update(conn -> {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setLong(1, pk);
            return ps;
        });
    }
}
