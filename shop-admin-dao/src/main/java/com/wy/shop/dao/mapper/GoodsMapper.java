package com.wy.shop.dao.mapper;

import com.wy.shop.dao.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:40
 */
public interface GoodsMapper {

    public Integer queryGoodsCount();

    public int batchInsertGoods(@Param("list") List<Goods> goodsList);

    public List<Goods> queryGoodsList();

}
