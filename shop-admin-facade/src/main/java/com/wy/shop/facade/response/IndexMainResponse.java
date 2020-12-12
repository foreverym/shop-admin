package com.wy.shop.facade.response;

import com.wy.shop.facade.domain.IndexMainVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  17:13
 */
@Data
public class IndexMainResponse {

    private Integer addCart;
    private Integer addOrderNum;
    private BigDecimal addOrderSum;
    private List<IndexMainVo> newData;
    private Integer newUser;
    private List<IndexMainVo> oldData;
    private Integer oldUser;
    private Integer payOrderNum;
    private BigDecimal payOrderSum;

}
