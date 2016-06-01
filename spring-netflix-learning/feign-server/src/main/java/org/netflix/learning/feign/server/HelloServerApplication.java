package org.netflix.learning.feign.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lingfeng on 2016/6/1.
 */
@SpringBootApplication
@EnableEurekaClient
@RestController
public class HelloServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(HelloServerApplication.class, args);
    }

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("/")
    public String hello() {
        ServiceInstance localInstance = client.getLocalServiceInstance();
        return "Hello World: " +
                localInstance.getServiceId() + ": " + localInstance.getHost() + ": " + localInstance.getPort();
    }
}
