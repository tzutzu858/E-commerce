package com.company.store.service.imp;

import com.company.store.domain.Goods;
import com.company.store.service.GoodsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class GoodsServiceImpTest {

    GoodsService goodsService;

    @BeforeEach
    void setUp() {
        goodsService = new GoodsServiceImp();
    }

    @AfterEach
    void tearDown() {
        goodsService = null;
    }

    @Test
    void queryAll() {

        List<Goods> list = goodsService.queryAll();
        assertEquals(2, list.size());

        Goods goods = list.get(0);
        assertEquals(1L, goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉", goods.getName());
        assertEquals(10000, goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生", goods.getDescription());
        assertEquals("2.jpg", goods.getImage());

    }

    @Test
    void queryByStartEnd() {
        List<Goods> list = goodsService.queryByStartEnd(0, 10);
        assertEquals(2, list.size());

        Goods goods = list.get(0);
        assertEquals(1L, goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉", goods.getName());
        assertEquals(10000, goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生", goods.getDescription());
        assertEquals("2.jpg", goods.getImage());
    }

    @Test
    void querDetail() {
        Goods goods = goodsService.queryDetail(1L);
        assertNotNull(goods);
        assertEquals(1L, goods.getId());
        assertEquals("淒慘霓虹燈～轉啊轉", goods.getName());
        assertEquals(10000, goods.getPrice());
        assertEquals("看那七彩的霓虹燈 它的發明者是愛迪生", goods.getDescription());
        assertEquals("2.jpg", goods.getImage());

    }
}