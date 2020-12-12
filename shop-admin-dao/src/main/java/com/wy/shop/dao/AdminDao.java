package com.wy.shop.dao;

import com.wy.shop.common.exception.DaoException;
import com.wy.shop.dao.entity.Admin;
import com.wy.shop.dao.entity.AdminLogin;

/**
 * @author : WangYB
 * @time: 2020/12/9  20:32
 */
public interface AdminDao {

    public Admin queryLoginAdmin(String username) throws DaoException;

}
