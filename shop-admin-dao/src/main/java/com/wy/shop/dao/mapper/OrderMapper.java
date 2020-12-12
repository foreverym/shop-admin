package com.wy.shop.dao.mapper;

import com.wy.shop.dao.entity.OrderIndexMain;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:25
 */
public interface OrderMapper {

    public Integer queryPrepareDeliveryOrder();

    public OrderIndexMain queryIndexMainOrderInfo();

}
