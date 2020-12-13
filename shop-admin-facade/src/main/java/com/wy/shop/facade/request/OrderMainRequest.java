package com.wy.shop.facade.request;

import lombok.Data;

/**
 * @author wangyibo
 */
@Data
public class OrderMainRequest {

    private Integer page;
    private String orderSn;
    private String consignee;
    private String logistic_code;
    private Integer status;

}
