package com.wy.shop.dao.impl;

import com.wy.shop.common.exception.DaoException;
import com.wy.shop.dao.AdminDao;
import com.wy.shop.dao.entity.Admin;
import com.wy.shop.dao.entity.AdminLogin;
import com.wy.shop.dao.mapper.AdminMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : WangYB
 * @time: 2020/12/9  20:34
 */
@Service("adminDao")
public class AdminDaoImpl implements AdminDao {

    @Autowired
    AdminMapper adminMapper;

    @Override
    public Admin queryLoginAdmin(String username) throws DaoException {
        Admin record = adminMapper.queryLoginAdmin(username);
        if (null == record) {
            throw DaoException.DAO_SELECTONE_IS_NULL.print();
        }
        return record;
    }

}
