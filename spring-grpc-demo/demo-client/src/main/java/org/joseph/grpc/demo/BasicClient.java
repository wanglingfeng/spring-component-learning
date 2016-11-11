package org.joseph.grpc.demo;

/*import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;

import java.util.concurrent.ExecutionException;*/

/**
 * client端，不整合spring去使用grpc
 *
 * Created by lfwang on 2016/11/7.
 */
/*public class BasicClient {

    public static void main(String... args) throws InterruptedException, ExecutionException {
        GreeterOuterClass.HelloRequest request = GreeterOuterClass.HelloRequest.newBuilder().setName("ppap").build();

        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 6560)
                .usePlaintext(true)
                .build();

        // 同步
        GreeterGrpc.GreeterBlockingStub stub = GreeterGrpc.newBlockingStub(channel);
        GreeterOuterClass.HelloReply result = stub.sayHello(request);

        // 异步
        *//*GreeterGrpc.GreeterFutureStub futureStub = GreeterGrpc.newFutureStub(channel);
        // 会在此阻塞
        GreeterOuterClass.HelloReply futureResult = futureStub.sayHello(request).get();*//*

        channel.shutdownNow();

        System.out.println(result);
    }
}*/
