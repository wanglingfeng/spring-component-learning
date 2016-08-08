package com.redis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by Lingfeng on 2016/8/5.
 */
@SpringBootApplication
@ComponentScan("com.redis")
public class RedisApplication {

    public static void main(String... args) {
        SpringApplication.run(RedisApplication.class, args);
    }

    /*@Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024); // 最大实例数
        config.setMaxIdle(200); // 最大空闲实例数
        config.setMaxWaitMillis(1000); // 最大等待时间（创建实例时）
        config.setTestOnBorrow(true); // 是否验证（创建实例时）

        return config;
    }

    @Bean
    public JedisConnectionFactory jedisFactory() {
        JedisConnectionFactory jedisFactory = new JedisConnectionFactory();
        jedisFactory.setHostName("localhost");
        jedisFactory.setPort(6379);
        jedisFactory.setUsePool(true);
        jedisFactory.setPoolConfig(jedisPoolConfig());

        return jedisFactory;
    }

    @Bean
    public RedisTemplate redisTemplate() {
        RedisTemplate redisTemplate = new RedisTemplate();
        redisTemplate.setConnectionFactory(jedisFactory());

        return redisTemplate;
    }*/
}
