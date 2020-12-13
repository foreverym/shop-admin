package com.wy.shop.dao.impl;

import com.wy.shop.dao.OrderDao;
import com.wy.shop.dao.entity.OrderExt;
import com.wy.shop.dao.entity.OrderIndexMain;
import com.wy.shop.dao.mapper.OrderMapper;
import com.wy.shop.dao.mapper.OrderMapperExt;
import java.util.List;
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
    @Autowired
    private OrderMapperExt orderMapperExt;

    @Override
    public Integer queryPrepareDeliveryOrder() {
        return orderMapper.queryPrepareDeliveryOrder();
    }

    @Override
    public OrderIndexMain queryIndexMainOrderInfo() {
        return orderMapper.queryIndexMainOrderInfo();
    }

    @Override
    public List<OrderExt> queryPageOrder() {
        System.out.println(orderMapperExt.queryPageOrder());
        return orderMapperExt.queryPageOrder();
    }

}
