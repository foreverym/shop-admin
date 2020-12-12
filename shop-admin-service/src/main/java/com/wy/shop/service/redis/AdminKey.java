package com.wy.shop.service.redis;

import static com.wy.shop.common.result.CodeMsg.TOKEN_EXPIRE;

/**
 * @author : WangYB
 * @time: 2020/12/10  15:25
 */
public class AdminKey extends BasePrefix {

    public static final int TOKEN_EXPIRE = 3600 * 24 * 2;

    private AdminKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }


    /**
     * 需要缓存的字段
     */
    public static AdminKey token = new AdminKey(TOKEN_EXPIRE, "token");
    public static AdminKey getByUsername = new AdminKey(0, "username");

}
