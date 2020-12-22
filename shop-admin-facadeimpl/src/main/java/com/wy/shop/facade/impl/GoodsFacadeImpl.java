package com.wy.shop.facade.impl;

import com.wy.shop.common.result.CodeMsg;
import com.wy.shop.common.result.Result;
import com.wy.shop.dao.entity.Goods;
import com.wy.shop.facade.GoodsFacade;
import com.wy.shop.facade.config.CommonUrlConfig;
import com.wy.shop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/22  16:13
 */
@RestController
@RequestMapping(CommonUrlConfig.GOODS_URL_PREFIX)
public class GoodsFacadeImpl implements GoodsFacade {

    @Autowired
    private GoodsService goodsService;

    @PostMapping(CommonUrlConfig.URL_GOODS_BATCH_UPLOAD)
    @Override
    public Result<Integer> uploadGoods() {
        int i = goodsService.batchInsertGoods();
        if (i > 0) {
            return Result.success(1);
        } else {
            return Result.error(CodeMsg.INSERT_GOODS_FAILURE);
        }
    }

}
