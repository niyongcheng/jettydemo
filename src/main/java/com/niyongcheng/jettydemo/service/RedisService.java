package com.niyongcheng.jettydemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.concurrent.TimeUnit;


@Component
public class RedisService {

    private final RedisTemplate redisTemplate;

    @Autowired
    public RedisService(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key,Object value){
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            result = true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }

    /**
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean setEx(final String key, Object value,Long expireTime){
        boolean result = false;
        try{
            ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
            operations.set(key,value);
            redisTemplate.expire(key,expireTime, TimeUnit.SECONDS);
            result = true;
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return  result;
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean exists(final String key){
        return redisTemplate.hasKey(key);
    }

    /**
     *
     * @param key
     * @return
     */
    public Object get(final String key){
        Object result = null;
        ValueOperations<Serializable,Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     *
     * @param key
     * @return
     */
    public boolean remove(final String key){
        if(exists(key)){
            //Boolean delete = redisTemplate.delete(key);
            //return delete;
            return true;
        }
        return false;
    }
}
