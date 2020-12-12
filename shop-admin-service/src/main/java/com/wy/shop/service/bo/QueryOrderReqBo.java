package com.wy.shop.service.bo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/12  15:37
 */
@Data
public class QueryOrderReqBo {

    /** 分页数 */
    private Integer page;
    /** 订单号 */
    private String orderSn;
    /** 收货人 */
    private String consignee;
    /** 快速号 */
    private String logistic_code;
    /** 订单状态 */
    private Integer status;

}
