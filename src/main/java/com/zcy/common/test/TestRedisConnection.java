package com.zcy.common.test;

import redis.clients.jedis.Jedis;

/**
 * @Description 测试 连接redis服务器
 * @author:caiyuan
 * @date:2019/8/21 0021
 * @ver:1.0
 **/
public class TestRedisConnection {

    private static Jedis jedis;
    static {
        jedis = new Jedis("129.28.180.167", 6379);
        jedis.auth("123456");
        System.out.println(jedis);
    }

    public static void main(String[] args) {
        jedis.set("java", "hello World!");
        System.out.println(jedis.get("java"));
        jedis.del("java");
        System.out.println(jedis.get("java"));
        jedis.close();
    }
}
