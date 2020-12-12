package com.wy.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.wy.shop.common.exception.DaoException;
import com.wy.shop.common.util.MD5Util;
import com.wy.shop.dao.AdminDao;
import com.wy.shop.dao.entity.Admin;
import com.wy.shop.dao.mapper.AdminMapper;
import com.wy.shop.service.AdminService;
import com.wy.shop.service.bo.AdminBo;
import com.wy.shop.service.bo.LoginReqBo;
import com.wy.shop.service.bo.RedisAdminBo;
import com.wy.shop.service.redis.AdminKey;
import com.wy.shop.service.redis.KeyPrefix;
import com.wy.shop.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author : WangYB
 * @time: 2020/12/10  15:07
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Autowired
    private RedisService redisService;


    @Override
    public AdminBo login(LoginReqBo loginReqBo, String token) throws DaoException {
        String username = loginReqBo.getUsername();
        String password = loginReqBo.getPassword();
        Admin admin = getAdminByToken(token);
        if (admin != null) {
            AdminBo adminBo = new AdminBo();
            adminBo.setId(admin.getId());
            adminBo.setUsername(admin.getUsername());
            return adminBo;
        }
        admin = getAdminByName(username);

        String salt = admin.getPasswordSalt();
        String checkPassword = admin.getPassword();
        token = UUID.randomUUID().toString();
        if (isRightPassword(password, checkPassword, salt)) {
            saveAdmin(admin, token);
        }

        AdminBo adminBo = new AdminBo();
        adminBo.setId(admin.getId());
        adminBo.setUsername(admin.getUsername());
        adminBo.setToken(token);
        return adminBo;
    }


    /**
     * 根据用户名获取用户对象
     *
     * @param username
     * @return
     * @throws DaoException
     */
    public Admin getAdminByName(String username) throws DaoException {
        Admin admin = new Admin();
        admin = adminDao.queryLoginAdmin(username);
        return admin;
    }

    /**
     * 检验密码是否正确
     *
     * @param password
     * @param checkPassword
     * @param salt
     * @return
     */
    public boolean isRightPassword(String password, String checkPassword, String salt) {
        String encryptPassword = MD5Util.inputPassToDbPass(password, salt);
        if (encryptPassword.equals(checkPassword)) {
            return true;
        }
        return false;
    }

    /**
     * 将用户信息保存在redis中
     *
     * @param admin
     */
    public void saveAdmin(Admin admin, String token) {
        KeyPrefix keyPrefix = AdminKey.token;
        admin.setPassword(null);
        admin.setPasswordSalt(null);
        String value = JSON.toJSONString(admin);
        redisService.set(keyPrefix, token, value);
    }

    /**
     * 根据token从Redis中取出数据
     *
     * @param token
     * @return
     */
    public Admin getAdminByToken(String token) {
        KeyPrefix keyPrefix = AdminKey.token;
        Admin admin = redisService.get(keyPrefix, token, Admin.class);
        return admin;
    }


}
