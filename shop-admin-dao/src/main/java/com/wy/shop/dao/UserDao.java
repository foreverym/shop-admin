package com.wy.shop.dao;

import com.wy.shop.dao.entity.UserIndexMain;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:58
 */
public interface UserDao {

    public Integer queryUserCount();

    public List<UserIndexMain> queryUserList();


}
