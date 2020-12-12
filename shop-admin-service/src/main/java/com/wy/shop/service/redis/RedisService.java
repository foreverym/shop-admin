package com.wy.shop.service.redis;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wy.shop.service.bo.LoginReqBo;
import com.wy.shop.service.bo.RedisAdminBo;
import org.apache.commons.lang3.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.unbescape.css.CssStringEscapeLevel;

import java.util.concurrent.TimeUnit;

/**
 * @author : WangYB
 * @time: 2020/12/10  15:42
 */
@Service
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public <T> T get(KeyPrefix prefix, String key, Class<T> clazz) {
        String realKey = prefix.getPrefix() + key;
        String valueStr = redisTemplate.opsForValue().get(realKey);
        if (valueStr == null || valueStr.length()==0) {
            return null;
        }
        String substring = valueStr.substring(1, valueStr.length()-1);
        String s = StringEscapeUtils.unescapeJava(substring);
        T value = JSONObject.parseObject(s, clazz);
        return value;
    }

    public <T> boolean set(KeyPrefix prefix, String key, T value) {
            String realKey = prefix.getPrefix() + key;
            String valueStr = JSON.toJSONString(value);
            int expireSeconds = prefix.expireSeconds();
            if (expireSeconds <= 0) {
                redisTemplate.opsForValue().set(realKey, valueStr);
            } else {
                redisTemplate.opsForValue().set(realKey, valueStr, prefix.expireSeconds(), TimeUnit.SECONDS);
            }
            return true;
    }

    public static void main(String[] args) {
        RedisAdminBo redisService = JSONObject.parseObject( "{\"id\":14,\"is_delete\":0,\"lastLoginIp\":\"::ffff:125.120.155.17\",\"lastLoginTime\":1575036217,\"username\":\"hiolabs\"}", RedisAdminBo.class);
        System.out.println(redisService);
    }
}
