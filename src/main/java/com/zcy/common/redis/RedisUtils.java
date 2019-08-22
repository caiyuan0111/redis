package com.zcy.common.redis;

/**
 * @Description
 * @author:caiyuan
 * @date:2019/8/12 0012
 * @ver:1.0
 **/
public interface RedisUtils {

    String set(String key, String value);

    String get(String key);

    Boolean exists(String key);

    Long expire(String key, int seconds);

    Long ttl(String key);

    Long incr(String key);

    Long hset(String key, String field, String value);

    String hget(String key, String field);

    Long hdel(String key, String... field);

}
