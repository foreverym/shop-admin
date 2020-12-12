package com.wy.shop.dao;

import com.wy.shop.dao.entity.OrderIndexMain;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:33
 */
public interface OrderDao {

    public Integer queryPrepareDeliveryOrder();

    public OrderIndexMain queryIndexMainOrderInfo();

}
