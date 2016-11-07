package org.joseph.grpc.demo.service;

import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;
import io.grpc.stub.StreamObserver;
import org.joseph.grpc.demo.interceptor.LogInterceptor;
import org.lognet.springboot.grpc.GRpcService;

/**
 * say hell ogrpc服务端（使用拦截器）
 *
 * Created by lfwang on 2016/11/7.
 */
@GRpcService(interceptors = {LogInterceptor.class})
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(GreeterOuterClass.HelloRequest request,
                         StreamObserver<GreeterOuterClass.HelloReply> responseObserver) {
        GreeterOuterClass.HelloReply.Builder replyBuilder = GreeterOuterClass.HelloReply
                .newBuilder()
                .setMessage("Hello " + request.getName());

        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}
