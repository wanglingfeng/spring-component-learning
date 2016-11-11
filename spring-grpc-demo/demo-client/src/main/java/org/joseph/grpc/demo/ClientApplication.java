package org.joseph.grpc.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.concurrent.TimeUnit;

/**
 * client端，整合spring去使用grpc
 *
 * Created by lfwang on 2016/11/7.
 */
@SpringBootApplication
@ComponentScan({"org.joseph.grpc.demo"})
public class ClientApplication {

    @Value("${server.grpc.port}")
    private int grpcPort;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", grpcPort)
                .usePlaintext(true)
                // 空闲模式保持一分钟，然后断开所有连接
                .idleTimeout(1, TimeUnit.MINUTES)
                .build();
    }
}
