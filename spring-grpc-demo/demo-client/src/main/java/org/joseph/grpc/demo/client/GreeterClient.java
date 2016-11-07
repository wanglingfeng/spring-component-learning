package org.joseph.grpc.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * Created by lfwang on 2016/11/7.
 */
@Service
public class GreeterClient {

    @Autowired
    private ManagedChannel managedChannel;

    public String sayHello(String name) {
        GreeterGrpc.GreeterFutureStub greeterFutureStub = GreeterGrpc.newFutureStub(managedChannel);
        GreeterOuterClass.HelloRequest helloRequest = GreeterOuterClass.HelloRequest.newBuilder()
                .setName(name).build();

        String reply = "";
        try {
            reply = greeterFutureStub.sayHello(helloRequest).get().getMessage();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return reply;
    }
}
