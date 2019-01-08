package com.panda.common.utils.redis;

import org.springframework.stereotype.Repository;

/**
 * @author Jamie
 */
public interface RedisDao {

    /**
     * 普通缓存获取
     *
     * @param key
     * @return
     */
    Object get(String key);

    /**
     * 普通缓存放入
     *
     * @param key
     * @param value
     * @return
     */
    boolean set(String key, Object value);

    /**
     * 普通缓存放入并设置时间
     *
     * @param key
     * @param value
     * @param time  时间(秒) time要大于0 如果time小于等于0 将设置无限期
     * @return true成功 false 失败
     */
    boolean set(String key, Object value, long time);

    /**
     * 指定缓存失效时间
     * @param key
     * @param time
     * @return
     */
    boolean expire(String key, long time);
}