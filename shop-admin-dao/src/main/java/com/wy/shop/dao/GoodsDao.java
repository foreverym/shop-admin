package com.wy.shop.dao;

import com.wy.shop.dao.entity.Goods;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:47
 */
public interface GoodsDao {

    public Integer queryGoodsCount();

    public int batchInsertGoods();

    public List<Goods> queryGoodsList();

}
