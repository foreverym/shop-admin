package com.wy.shop.service;

import com.wy.shop.dao.entity.OrderExt;
import com.wy.shop.service.bo.OrderPageBo;
import java.util.List;

/**
 * @author wangyibo
 */
public interface OrderService {

    public List<OrderPageBo> queryPageOrder();

    public Integer queryOrderCount();

}
