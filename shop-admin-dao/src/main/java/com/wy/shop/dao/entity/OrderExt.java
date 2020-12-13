package com.wy.shop.dao.entity;

import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/12  16:20
 */
@Data
public class OrderExt {


    /**
     * id : 1330
     * order_sn : 20191005170626623520
     * user_id : 1048
     * order_status : 300
     * offline_pay : 1
     * shipping_status : 0
     * print_status : 0
     * pay_status : 2
     * consignee : 测试
     * country : 0
     * province : 3
     * city : 38
     * district : 422
     * address : 测试地址
     * print_info : 1、懒人椅【1】
     * mobile : 13333232323
     * postscript :
     * admin_memo : null
     * shipping_fee : 0
     * pay_name :
     * pay_id : 4200000422201911290938060299
     * change_price : 0.01
     * actual_price : 0.01
     * order_price : 0.01
     * goods_price : 0.01
     * add_time : 2019-11-29 17:06:26
     * pay_time : 2019-11-29 17:06:31
     * shipping_time : 0
     * confirm_time : 0
     * dealdone_time : 0
     * freight_price : 0
     * express_value : 480
     * remark : 需电联客户请优先派送勿放快递柜
     * order_type : 0
     * is_delete : 0
     * goodsList : [{"goods_name":"日式和风懒人沙发","goods_aka":"懒人椅","list_pic_url":"http://yanxuan.nosdn.127.net/149dfa87a7324e184c5526ead81de9ad.png","number":1,"goods_specifition_name_value":"棕色","retail_price":0.01}]
     * goodsCount : 1
     * userInfo : {"nickname":"盛良🐠","name":"899809","mobile":"","avatar":"https://wx.qlogo.cn/mmopen/vi_32/Q0j4TwGTfTLJ1VBQSSEkJicx0tKYiaibPkBm2AOYoFciaibYS8FX91B3OYxbaGMloFJ4yibnbF1021O4g6ueiaR4qPVPA/132"}
     * full_region : 天津市天津市和平区
     * order_status_text : 待发货
     * expressInfo : 圆通速递YT2880409397161
     */

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
    private BigDecimal shipping_fee;
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
