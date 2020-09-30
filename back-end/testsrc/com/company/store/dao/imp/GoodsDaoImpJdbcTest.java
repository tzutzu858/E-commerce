package com.company.store.dao.imp;

import com.company.store.dao.GoodsDao;
import com.company.store.domain.Customer;
import com.company.store.domain.Goods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsDaoImpJdbcTest {

    GoodsDao dao;

    @BeforeEach
    void setUp() {
        dao = new GoodsDaoImpJdbc();
    }

    @AfterEach
    void tearDown() {
        dao = null;
    }

    @Test
    void findByPk() {

        Goods goods= dao.findByPk(3);
        assertNotNull(goods);
        assertEquals(3,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(30000,goods.getPrice());
        assertEquals("五個六個七個八個",goods.getDescription());
        assertEquals("3.jpg",goods.getImage());
    }

    @Test
    void findAll() {
        List<Goods> list = dao.findAll();
        assertEquals(list.size(),40);

        Goods goods= list.get(2);
        assertNotNull(goods);
        assertEquals(3,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(30000,goods.getPrice());
        assertEquals("五個六個七個八個",goods.getDescription());
        assertEquals("3.jpg",goods.getImage());

    }

    @Test
    void findStartEnd() {
        List<Goods> list = dao.findStartEnd(0,10);

        assertEquals(list.size(),10);
        Goods goods= list.get(2);
        assertNotNull(goods);
        assertEquals(3,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(30000,goods.getPrice());
        assertEquals("五個六個七個八個",goods.getDescription());
        assertEquals("3.jpg",goods.getImage());
    }

    @Test
    void create() {
    }

    @Test
    void modify() {
    }

    @Test
    void remove() {
    }
}