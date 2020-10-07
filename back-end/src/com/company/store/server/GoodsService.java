package com.company.store.server;

import com.company.store.domain.Goods;

import java.util.List;

public interface GoodsService {

    //查詢所有商品
    List<Goods> queryAll();
    //按照開始索引及結束索引查詢
    List<Goods> queryByStartEnd(int start ,int end);

    Goods queryDetail(long goodsid);
}
