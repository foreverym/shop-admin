package com.wy.shop.dao.impl;

import com.wy.shop.dao.OrderDao;
import com.wy.shop.dao.entity.OrderIndexMain;
import com.wy.shop.dao.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:34
 */
@Service("orderDao")
public class OrderDaoImpl implements OrderDao {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Integer queryPrepareDeliveryOrder() {
        return orderMapper.queryPrepareDeliveryOrder();
    }

    @Override
    public OrderIndexMain queryIndexMainOrderInfo() {
        return orderMapper.queryIndexMainOrderInfo();
    }

}
