package com.wy.shop.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * @author : WangYB
 * @time: 2020/12/9  19:54
 */
@Data
public class Admin {

    private Integer id;
    private String username;
    private String password;
    private String passwordSalt;
    private String lastLoginIp;
    private Long lastLoginTime;
    private Integer is_delete;

}
