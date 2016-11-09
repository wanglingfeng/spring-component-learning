package org.joseph.grpc.demo;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.examples.GreeterGrpc;
import org.joseph.grpc.demo.service.GreeterService;

import java.io.IOException;

/**
 * server端，不整合spring去使用grpc
 *
 * Created by lfwang on 2016/11/7.
 */
public class BasicServer {
    public static void main(String... args) {
        BasicServer server = new BasicServer();
        server.run();
    }

    public void run() {
        int port = 6560;

        GreeterGrpc.GreeterImplBase greeterImplBase = new GreeterService();
        Server server = ServerBuilder.forPort(port).addService(greeterImplBase.bindService()).build();

        try {
            server.start();
            System.out.println("Server start success on port: " + port);
            server.awaitTermination();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
