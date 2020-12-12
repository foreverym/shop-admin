package com.wy.shop.service.bo;

import lombok.Data;

/**
 * @author : WangYB
 * @time: 2020/12/11  17:16
 */
@Data
public class UserIndexMainBo {

    private Integer id;
    private String avatar;
    private Integer gender;
    private String nickName;
    private Long register_time;
    private Long last_login_time;

}
