package com.zcy.common.redis;

import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPool;

/**
 * @Description
 * @author:caiyuan
 * @date:2019/8/12 0012
 * @ver:1.0
 **/
public class RedisPool implements RedisUtils {

    @Autowired
    private JedisPool jedisPool;

    @Override
    public String set(String key, String value) {
        return null;
    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public Boolean exists(String key) {
        return null;
    }

    @Override
    public Long expire(String key, int seconds) {
        return null;
    }

    @Override
    public Long ttl(String key) {
        return null;
    }

    @Override
    public Long incr(String key) {
        return null;
    }

    @Override
    public Long hset(String key, String field, String value) {
        return null;
    }

    @Override
    public String hget(String key, String field) {
        return null;
    }

    @Override
    public Long hdel(String key, String... field) {
        return null;
    }
}
