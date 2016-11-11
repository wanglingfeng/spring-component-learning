package com.redis.test;

import com.redis.RedisApplication;
import com.redis.init.with.configuration.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * Created by Lingfeng on 2016/8/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = RedisApplication.class)
@WebAppConfiguration
public class UserTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void create() {
        UserRepository.User u = new UserRepository.User();
        u.setName("lfwang");
        u.setAge(26);

        userRepository.save("ASD123", u);
    }

    @Test
    public void find() {
        UserRepository.User u = userRepository.get("ASD123");

        System.out.println(u);
    }

    @Test
    public void update() {
        String id = "ASD123";

        UserRepository.User u = userRepository.get(id);
        System.out.println("before update" + u);

        u.setName("joseph");
        u.setAge(18);

        userRepository.save(id, u);

        UserRepository.User uUpdated = userRepository.get(id);
        System.out.println("after update" + uUpdated);
    }

    @Test
    public void delete() {
        userRepository.delete("ASD123");
    }
}
