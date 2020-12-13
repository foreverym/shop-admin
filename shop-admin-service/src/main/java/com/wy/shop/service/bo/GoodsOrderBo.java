package com.wy.shop.service.bo;

import java.math.BigDecimal;
import lombok.Data;

/**
 * @author wangyibo
 */
@Data
public class GoodsOrderBo {

    private String goods_name;
    private String goods_aka;
    private String list_pic_url;
    private Integer number;
    private String goods_specifition_name_value;
    private BigDecimal retail_price;

}
