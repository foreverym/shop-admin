package com.wy.shop.dao.impl;

import com.wy.shop.common.redis.RedisService;
import com.wy.shop.dao.GoodsDao;
import com.wy.shop.dao.entity.Goods;
import com.wy.shop.dao.mapper.GoodsMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:48
 */
@Service
public class GoodsDaoImpl implements GoodsDao {

    public static final String GOODSPREFIX = "goods";

    public static final Logger logger = LoggerFactory.getLogger(GoodsDaoImpl.class);

    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    @Qualifier("commonRedisService")
    private RedisService redisService;

    @Override
    public Integer queryGoodsCount() {
        return goodsMapper.queryGoodsCount();
    }

    @Override
    public int batchInsertGoods() {
        List<Goods> goodsList = queryGoodsList();
        int i = goodsMapper.batchInsertGoods(goodsList);
        logger.info(">>>>>>>>>goodsList: {}",goodsList);
        for (Goods goods : goodsList) {
            redisService.setValue(GOODSPREFIX, goods.getId().toString(),
                    goods.getGoods_number().toString());
        }

        return i;
    }

    @Override
    public List<Goods> queryGoodsList() {
        return goodsMapper.queryGoodsList();
    }


}
