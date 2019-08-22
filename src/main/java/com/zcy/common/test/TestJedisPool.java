package com.zcy.common.test;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @Description 测试 jedisPool 连接池使用
 * @author:caiyuan
 * @date:2019/8/22 0022
 * @ver:1.0
 **/
public class TestJedisPool {

    private static JedisPool jedisPool;
    static {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        jedisPool = new JedisPool(config, "129.28.180.167", 6379, 3000, "123456");
    }

    public static void main(String[] args) {
        Jedis jedis = jedisPool.getResource();
        jedis.set("java", "hello World!");
        System.out.println(jedis.get("java"));
        jedis.close();
        jedisPool.close();
    }
}
