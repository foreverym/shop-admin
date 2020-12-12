package com.wy.shop.service;

import com.wy.shop.common.exception.DaoException;
import com.wy.shop.service.bo.AdminBo;
import com.wy.shop.service.bo.LoginReqBo;

/**
 * @author : WangYB
 * @time: 2020/12/10  14:57
 */
public interface AdminService {

    public AdminBo login(LoginReqBo loginReqBo, String token) throws DaoException;

}
