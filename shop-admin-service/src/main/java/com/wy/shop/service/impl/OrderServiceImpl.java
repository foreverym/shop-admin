package com.wy.shop.service.impl;

import com.wy.shop.dao.OrderDao;
import com.wy.shop.dao.entity.OrderExt;
import com.wy.shop.service.OrderService;
import com.wy.shop.service.bo.OrderPageBo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author wangyibo
 */
@Service
public class OrderServiceImpl implements OrderService {

    public static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<OrderPageBo> queryPageOrder() {
        List<OrderExt> orderExtList = orderDao.queryPageOrder();
        List<OrderPageBo> orderPageBoList = orderExtList.stream().map(orderExt -> {
            OrderPageBo orderPageBo = new OrderPageBo();
            BeanUtils.copyProperties(orderExt, orderPageBo);
            return orderPageBo;
        }).collect(Collectors.toList());
        return orderPageBoList;
    }
}
