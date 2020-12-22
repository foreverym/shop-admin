package com.wy.shop.service.impl;

import com.wy.shop.dao.GoodsDao;
import com.wy.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.AccessType;
import org.springframework.stereotype.Service;

/**
 *
 * @author : WangYB
 * @time: 2020/12/22  18:41
 *
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    @Override
    public int batchInsertGoods() {
        return goodsDao.batchInsertGoods();
    }

}
