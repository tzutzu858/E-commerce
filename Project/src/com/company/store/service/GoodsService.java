package com.company.store.service;

import com.company.store.domain.Goods;

import java.util.List;

public interface GoodsService {
    List<Goods> queryAll();

    List<Goods> queryByStartEnd(int start, int end);

    Goods queryDetail(long goodsid);

}
