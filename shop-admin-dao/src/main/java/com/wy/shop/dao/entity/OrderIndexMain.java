package com.wy.shop.dao.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : WangYB
 * @time: 2020/12/11  14:33
 */
@Data
public class OrderIndexMain {

    private Integer addCart;
    private Integer addOrderNum;
    private BigDecimal addOrderSum;
    private Integer payOrderNum;
    private BigDecimal payOrderSum;

}
