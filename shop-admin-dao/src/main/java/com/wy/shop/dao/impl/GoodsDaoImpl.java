package com.wy.shop.dao.impl;

import com.wy.shop.dao.GoodsDao;
import com.wy.shop.dao.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:48
 */
@Service
public class GoodsDaoImpl implements GoodsDao {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public Integer queryGoodsCount() {
        return goodsMapper.queryGoodsCount();
    }
}
