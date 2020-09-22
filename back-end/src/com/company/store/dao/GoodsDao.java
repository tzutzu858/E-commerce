package com.company.store.dao;

import com.company.store.domain.Goods;

import java.util.List;

public interface GoodsDao {

    Goods findByPk(long pk);

    List<Goods> findAll();

    /**
     * 提供分頁查詢
     * @param start 開始索引 索引從0開始
     * @param end   結束索引 索引從0開始
     * @return 商品列表
     */
    List<Goods> findStartEnd(int start ,int end);

    void create(Goods goods);

    void modify(Goods goods);

    void remove(long pk);
}
