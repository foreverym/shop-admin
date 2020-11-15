package com.wy.shop.mapper;

import com.wy.shop.entity.Order;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AdminMapper {

//    @Select("SELECT * FROM seckill_order WHERE id=11")
    public Order getOrder();

}
