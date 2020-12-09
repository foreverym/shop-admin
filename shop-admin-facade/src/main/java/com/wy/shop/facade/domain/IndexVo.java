package com.wy.shop.facade.domain;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/9  11:23
 */
@Data
public class IndexVo {

    private Integer goodsOnsale;
    private Integer orderToDelivery;
    private Long timestamp;
    private Integer user;

}
