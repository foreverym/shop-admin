package com.wy.shop.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : WangYB
 * @time: 2020/12/11  14:09
 */
@Data
public class UserIndexMain {

    private Integer id;
    private String avatar;
    private Integer gender;
    private String nickName;
    private Long register_time;
    private Long last_login_time;

}
