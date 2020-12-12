package com.wy.shop.dao.mapper;

import com.wy.shop.dao.entity.Admin;
import com.wy.shop.dao.entity.AdminLogin;

/**
 * @author : WangYB
 * @time: 2020/12/9  20:31
 */
public interface AdminMapper {

    public Admin queryLoginAdmin(String username);

}
