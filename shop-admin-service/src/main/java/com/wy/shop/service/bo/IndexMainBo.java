package com.wy.shop.service.bo;

import com.wy.shop.dao.entity.User;
import com.wy.shop.dao.entity.UserIndexMain;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  13:44
 */
@Data
public class IndexMainBo {

    private Integer addCart;
    private Integer addOrderNum;
    private BigDecimal addOrderSum;
    private List<UserIndexMainBo> newData;
    private Integer newUser;
    private List<UserIndexMainBo> oldData;
    private Integer oldUser;
    private Integer payOrderNum;
    private BigDecimal payOrderSum;

}
