package com.company.store.dao.imp;

import com.company.store.dao.GoodsDao;
import com.company.store.domain.Goods;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;


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
        Goods goods =  dao.findByPk(1L);
        assertNotNull(goods);
        assertEquals(1L,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(10000,goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生",goods.getDescription());
        assertEquals("1.jpg",goods.getImage());

    }

    @Test
    void findAll() {
        List<Goods> list = dao.findAll();
        assertEquals(((List) list).size(),40);

        Goods goods =list.get(0);
        assertNotNull(goods);
        assertEquals(1L,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(10000,goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生",goods.getDescription());
        assertEquals("1.jpg",goods.getImage());



    }

    @Test
    void findStartEnd() {
        List <Goods> list = dao.findStartEnd(0,4);
        assertEquals(4,list.size());

        Goods goods =list.get(0);
        assertNotNull(goods);
        assertEquals(1L,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(10000,goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生",goods.getDescription());
        assertEquals("1.jpg",goods.getImage());

    }

    @Test
    void create() {
        Goods goods = new Goods();
        goods.setId(23L);
        goods.setName("淒慘霓虹燈～轉啊轉");
        goods.setPrice(10000);
        goods.setDescription("看那七彩的霓虹燈 它的發明者是愛迪生");
        goods.setImage("1.jpg");

        dao.create(goods);
        Goods goods1 = dao.findByPk(23L);
        assertNotNull(goods);
        assertEquals(23L,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(10000,goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生",goods.getDescription());
        assertEquals("1.jpg",goods.getImage());
    }

    @Test
    void modify() {
        Goods goods = new Goods();
        goods.setId(1L);
        goods.setName("淒慘霓虹燈～轉啊轉");
        goods.setPrice(10000);
        goods.setDescription("看那七彩的霓虹燈 它的發明者是愛迪生");
        goods.setImage("2.jpg");

        dao.modify(goods);
        Goods goods1 = dao.findByPk(1L);
        assertNotNull(goods);
        assertEquals(1L,goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉",goods.getName());
        assertEquals(10000,goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生",goods.getDescription());
        assertEquals("2.jpg",goods.getImage());

    }

    @Test
    void remove() {
        dao.remove(1L);

        Goods goods = dao.findByPk(1L);
        assertNull(goods);
    }
}