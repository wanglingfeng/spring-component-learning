package org.joseph.grpc.demo.service;

import io.grpc.examples.CalculatorGrpc;
import io.grpc.examples.CalculatorOuterClass;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;

/**
 * 数学计算grpc服务端（未使用拦截器）
 *
 * Created by lfwang on 2016/11/7.
 */
@GRpcService
public class CalculatorService extends CalculatorGrpc.CalculatorImplBase {

    @Override
    public void calculate(CalculatorOuterClass.CalculatorRequest request,
                          StreamObserver<CalculatorOuterClass.CalculatorResponse> responseObserver) {
        CalculatorOuterClass.CalculatorResponse.Builder resultBuilder = CalculatorOuterClass.CalculatorResponse
                .newBuilder();

        switch (request.getOperation()) {
            case ADD:
                resultBuilder.setResult(request.getNumber1() + request.getNumber2());
                break;
            case SUBTRACT:
                resultBuilder.setResult(request.getNumber1() - request.getNumber2());
                break;
            case MULTIPLY:
                resultBuilder.setResult(request.getNumber1() * request.getNumber2());
                break;
            case DIVIDE:
                resultBuilder.setResult(request.getNumber1() / request.getNumber2());
                break;
            case UNRECOGNIZED:
                break;
        }

        responseObserver.onNext(resultBuilder.build());
        responseObserver.onCompleted();
    }
}
