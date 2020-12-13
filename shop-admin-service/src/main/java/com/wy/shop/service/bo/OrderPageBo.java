package com.wy.shop.service.bo;

import com.wy.shop.dao.entity.GoodsOrder;
import com.wy.shop.dao.entity.UserOrder;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * @author wangyibo
 */
@Data
public class OrderPageBo {

    private Integer id;
    private String order_sn;
    private Integer user_id;
    private Integer order_status;
    private Integer offline_pay;
    private Integer shipping_status;
    private Integer print_status;
    private Integer pay_status;
    private String consignee;
    private Integer country;
    private Integer province;
    private Integer city;
    private Integer district;
    private String address;
    private String print_info;
    private String mobile;
    private String postscript;
    private Object admin_memo;
    private Integer shipping_fee;
    private String pay_name;
    private String pay_id;
    private BigDecimal change_price;
    private BigDecimal actual_price;
    private BigDecimal order_price;
    private BigDecimal goods_price;
    private String add_time;
    private String pay_time;
    private Integer shipping_time;
    private Integer confirm_time;
    private Integer dealdone_time;
    private Integer freight_price;
    private Integer express_value;
    private String remark;
    private Integer order_type;
    private Integer is_delete;
    private Integer goodsCount;
    private String full_region;
    private String order_status_text;
    private String expressInfo;
    private UserOrder userInfo;
    private List<GoodsOrder> goodsList;

}
