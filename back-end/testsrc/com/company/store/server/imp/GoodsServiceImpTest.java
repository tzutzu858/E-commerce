package com.company.store.server.imp;

import com.company.store.domain.Goods;
import com.company.store.server.GoodsService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GoodsServiceImpTest {
    GoodsService goodsService ;
    @BeforeEach
    void setUp() {
        goodsService=new GoodsServiceImp();
    }

    @AfterEach
    void tearDown() {
        goodsService=null;
    }

    @Test
    void queryAll() {
        List<Goods> list = goodsService.queryAll();

        assertEquals(34,list.size());
        Goods goods =list.get(2);

//        我是用local的 資料庫 記得改成遠端資料測試
        assertEquals(3L,goods.getId());
        assertEquals(24792,goods.getPrice());
        assertEquals("聯想510S",goods.getName());
        assertEquals("聯想（Lenovo）天逸510S商用桌上型電腦組合（i3-7100 4G 1T 內顯 WiFi 藍芽 三年保固 win10）19.5吋",goods.getDescription());
        assertEquals("5a6e946eNd622e938.jpg",goods.getImage());
    }

    @Test
    void queryByStartEnd() {
        List<Goods> list = goodsService.queryByStartEnd(0,10);
        assertEquals(10,list.size());

        Goods goods = list.get(2);
        assertEquals(3L,goods.getId());
        assertEquals(24792,goods.getPrice());
        assertEquals("聯想510S",goods.getName());
        assertEquals("聯想（Lenovo）天逸510S商用桌上型電腦組合（i3-7100 4G 1T 內顯 WiFi 藍芽 三年保固 win10）19.5吋",goods.getDescription());
        assertEquals("5a6e946eNd622e938.jpg",goods.getImage());
    }

    @Test
    void queryDetail() {
        Goods goods = goodsService.queryDetail(3L);
        assertNotNull(goods);
        assertEquals(3L,goods.getId());
        assertEquals(24792,goods.getPrice());
        assertEquals("聯想510S",goods.getName());
        assertEquals("聯想（Lenovo）天逸510S商用桌上型電腦組合（i3-7100 4G 1T 內顯 WiFi 藍芽 三年保固 win10）19.5吋",goods.getDescription());
        assertEquals("5a6e946eNd622e938.jpg",goods.getImage());
    }
}