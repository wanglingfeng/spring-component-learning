package org.joseph.grpc.demo.interceptor;

import io.grpc.Metadata;
import io.grpc.ServerCall;
import io.grpc.ServerCallHandler;
import io.grpc.ServerInterceptor;
import org.springframework.stereotype.Component;

/**
 * Created by lfwang on 2016/11/7.
 */
@Component
public class LogInterceptor implements ServerInterceptor {
    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(ServerCall<ReqT, RespT> call, Metadata headers,
                                                                 ServerCallHandler<ReqT, RespT> next) {
        System.out.println(call.getMethodDescriptor().getFullMethodName());

        return next.startCall(call, headers);
    }
}
