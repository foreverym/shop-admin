package com.wy.shop.dao.mapper;

import com.wy.shop.dao.entity.User;
import com.wy.shop.dao.entity.UserIndexMain;

import java.util.List;

/**
 * @author : WangYB
 * @time: 2020/12/11  10:50
 */

public interface UserMapper {

    public Integer queryUserCount();

    public List<UserIndexMain> queryUserList();

}
