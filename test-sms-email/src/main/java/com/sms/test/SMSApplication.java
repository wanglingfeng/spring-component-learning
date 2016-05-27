package com.sms.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Lingfeng on 2016/3/22.
 */
@SpringBootApplication
@ComponentScan("com.sms.test")
public class SMSApplication {

    public static void main(String[] args) {
        SpringApplication.run(SMSApplication.class, args);
    }
}
