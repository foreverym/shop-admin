package com.wy.shop.dao.impl;

import com.wy.shop.dao.UserDao;
import com.wy.shop.dao.entity.UserIndexMain;
import com.wy.shop.dao.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:58
 */
@Service
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Integer queryUserCount() {
        return userMapper.queryUserCount();
    }

    @Override
    public List<UserIndexMain> queryUserList() {
        return userMapper.queryUserList();
    }
}
