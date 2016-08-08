package com.redis.init.with.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by Lingfeng on 2016/8/8.
 */
@Configuration
public class RedisConfiguration {

    @Bean
    public RedisTemplate<String, ?> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, ?> template = new RedisTemplate<>();
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setConnectionFactory(connectionFactory);

        return template;
    }
}
