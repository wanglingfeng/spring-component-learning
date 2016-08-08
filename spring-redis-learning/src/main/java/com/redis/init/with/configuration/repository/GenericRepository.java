package com.redis.init.with.configuration.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.PostConstruct;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Lingfeng on 2016/8/8.
 */
public abstract class GenericRepository<T> {

    static final String BOUNDED_HASH_KEY_PREFIX = "lfwang:redis:";

    @Autowired
    private RedisTemplate<String, T> redisTemplate;
    private ValueOperations<String, T> valueOperations;

    @PostConstruct
    public void init() {
        Assert.notNull(redisTemplate, "redisOperations cannot be null");
        this.valueOperations = redisTemplate.opsForValue();
    }

    public void save(String id, T item) {
        if (StringUtils.isEmpty(id)) id = UUID.randomUUID().toString();
        String key = getKey(id);

        System.out.println(key);
        this.valueOperations.set(key, item, 1000 * 60 * 5, TimeUnit.MILLISECONDS); // redis中保存5分钟
    }

    public T get(String id) {
        String key = getKey(id);
        return this.valueOperations.get(key);
    }

    public void delete(String id) {
        String key = getKey(id);
        this.redisTemplate.delete(key);
    }

    public String getKey(String id) {
        return BOUNDED_HASH_KEY_PREFIX + id;
    }
}
