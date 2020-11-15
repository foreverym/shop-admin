package com.wy.shop.entity;

import lombok.Data;

/**
 * @author wangyibo
 */
@Data
public class Order {

    private Long id;
    private Long user_id;
    private Long order_id;
    private Long goods_id;

}
