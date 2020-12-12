package com.wy.shop.service.bo;

import com.wy.shop.dao.entity.Admin;
import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/10  14:28
 */
@Data
public class AdminBo {

    private Integer id;
    private String username;
    private String token;

}
