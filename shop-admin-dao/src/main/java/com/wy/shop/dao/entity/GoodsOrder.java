package com.wy.shop.dao.entity;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/12  16:35
 */
@Data
public class GoodsOrder {

    private String goods_name;
    private String goods_aka;
    private String list_pic_url;
    private Integer number;
    private String goods_specifition_name_value;
    private Double retail_price;

}
