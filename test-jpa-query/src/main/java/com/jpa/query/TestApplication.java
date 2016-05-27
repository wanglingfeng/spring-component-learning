package com.jpa.query;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Profile;

/**
 * Created by Lingfeng on 2015/9/30.
 */
@SpringBootApplication
@Profile("dev")
@ComponentScan("com.jpa.query")
public class TestApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class, args);
    }
}
