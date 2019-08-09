package com.zcy.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.CollectionUtils;

import java.util.concurrent.TimeUnit;

/**
 * @Description redis 工具类
 * @author:caiyuan
 * @date:2019/8/8 0008
 * @ver:1.0
 **/
public class RedisUtil {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 指定缓存失效时间
     *
     * @param key 键
     * @param time 时间
     * @return boolean
     * @methodName expire
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public boolean expire(String key,long time){
        try {
            if (time>0){
                redisTemplate.expire(key, time, TimeUnit.SECONDS);
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 根据key 获取过期时间
     *
     * @param key 键 不能为null
     * @return long 时间（秒） 返回0代表永久有效
     * @methodName getExpire
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public long getExpire(String key){
        return redisTemplate.getExpire(key, TimeUnit.SECONDS);
    }

    /**
     * 判断key是否存在
     *
     * @param key 键
     * @return boolean 存在为true
     * @methodName hasKey
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public boolean hasKey(String key){
        try {
            return redisTemplate.hasKey(key);
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 删除缓存
     * 
     * @param key 可以传一个值 或多个
     * @return void
     * @methodName del
     * @author caiyuan
     * @date 2019/8/8 0008 
     */
    @SuppressWarnings("unchecked")
    public void del(String... key){
        if (key !=null && key.length>0){
            if (key.length == 1){
                redisTemplate.delete(key[0]);
            }else{
                redisTemplate.delete(CollectionUtils.arrayToList(key));
            }
        }
    }

    //======================= String =========================

    /**
     * 普通缓存获取
     *
     * @param key 键
     * @return java.lang.Object
     * @methodName get
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public Object get(String key){
        return key == null ? null : redisTemplate.opsForValue().get(key);
    }

    /**
     * 普通缓存放入
     *
     * @param key   键
     * @param value 值
     * @return boolean true为成功
     * @methodName set
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public boolean set(String key, Object value) {
        try {
            redisTemplate.opsForValue().set(key, value);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 普通缓存放入并设置时间
     * 
     * @param key 键
     * @param value 值
     * @param time 时间（秒）time>0 如果time<=0 将设置无限期
     * @return boolean
     * @methodName set
     * @author caiyuan
     * @date 2019/8/8 0008 
     */
    public boolean set(String key, Object value, long time) {
        try {
            if (time > 0) {
                redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
            } else {
                set(key, value);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     *
     *
     * @param key 键
     * @param delta
     * @return long
     * @methodName incr
     * @author caiyuan
     * @date 2019/8/8 0008
     */
    public long incr(String key, long delta) {
        if (delta < 0) {
            throw new RuntimeException("递增因子必须大于0");
        }
        return redisTemplate.opsForValue().increment(key, delta);
    }

}
