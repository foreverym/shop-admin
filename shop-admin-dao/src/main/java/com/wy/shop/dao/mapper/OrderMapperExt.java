package com.wy.shop.dao.mapper;

import com.wy.shop.dao.entity.OrderExt;
import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/12  16:18
 */
public interface OrderMapperExt {

    public List<OrderExt> queryPageOrder();

}
