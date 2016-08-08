package com.redis.init.with.factory.repository;

/**
 * Created by Lingfeng on 2016/8/5.
 */
/*public class MyUserRepository {

    @Autowired
    private RedisTemplate<String, MyUser> template;

    private ValueOperations<String, MyUser> operations;

    @PostConstruct
    public void init() {
        // 在spring中进行redis存储，如果没有对key和value进行序列化，保存到redis中会出现乱码。
        // 注意看上面的redis模板配置，有个配置项是defaultSerializer，这里表示redis中的key和value遇到需要序列化的时候，
        // 都默认使用StringRedisSerializer这个类来进行序列化。如果不指定序列化的话，内容会带乱码。
        // · spring-data-redis的序列化类有下面这几个:
        // · GenericToStringSerializer: 可以将任何对象泛化为字符串并序列化
        // · Jackson2JsonRedisSerializer: 跟JacksonJsonRedisSerializer实际上是一样的
        // · JacksonJsonRedisSerializer: 序列化object对象为json字符串
        // · JdkSerializationRedisSerializer: 序列化java对象
        // · StringRedisSerializer: 简单的字符串序列化
        // 一般如果key-value都是string的话，使用StringRedisSerializer就可以了，
        // 如果需要保存对象为json的话推荐使用JacksonJsonRedisSerializer，
        // 它不仅可以将对象序列化，还可以将对象转换为json字符串并保存到redis中，但需要和jackson配合一起使用。

        //这里设置value的序列化方式为JacksonJsonRedisSerializer
        template.setValueSerializer(new JacksonJsonRedisSerializer<>(MyUser.class));
        operations = template.opsForValue();
    }

    public void set(String key, MyUser value) {
        operations.set(key, value);
    }

    public MyUser get(String key) {
        return operations.get(key);
    }
}*/
