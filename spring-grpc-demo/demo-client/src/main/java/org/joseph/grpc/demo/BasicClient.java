package org.joseph.grpc.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;

/**
 * client端，不整合spring去使用grpc
 *
 * Created by lfwang on 2016/11/7.
 */
public class BasicClient {

    public static void main(String... args) throws InterruptedException {
        GreeterOuterClass.HelloRequest request = GreeterOuterClass.HelloRequest.newBuilder().setName("ppap").build();

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 6560)
                .usePlaintext(true)
                .build();

        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        GreeterOuterClass.HelloReply result = stub.sayHello(request);

        channel.shutdownNow();

        System.out.println(result);
    }
}
