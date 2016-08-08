package com.redis.init.with.configuration.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by Lingfeng on 2016/8/8.
 */
@Repository
public class UserRepository extends GenericRepository<UserRepository.User> {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class User implements Serializable {

        private String name;
        private int age;
    }
}
