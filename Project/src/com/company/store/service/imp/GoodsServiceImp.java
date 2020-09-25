package com.company.store.service.imp;

import com.company.store.dao.GoodsDao;
import com.company.store.dao.imp.GoodsDaoImpJdbc;
import com.company.store.domain.Goods;
import com.company.store.service.GoodsService;

import java.util.List;

public class GoodsServiceImp implements GoodsService {
    GoodsDao goodsDao = new GoodsDaoImpJdbc();



    @Override
    public List<Goods> queryAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> queryByStartEnd(int start, int end) {
        return goodsDao.findStartEnd(start, end);
    }

    @Override
    public Goods queryDetail(long goodsid) {
        return goodsDao.findByPk(goodsid);
    }

}
