package com.wy.shop.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author : WangYB
 * @time: 2020/12/22  19:12
 */
@Service("commonRedisService")
public class RedisService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    public void setValue(String prefix, String key, String value) {
        String realKey = prefix + key;
        redisTemplate.opsForValue().set(realKey, value);
    }

}
