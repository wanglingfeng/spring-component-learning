package org.joseph.grpc.demo.client;

import io.grpc.ManagedChannel;
import io.grpc.examples.CalculatorGrpc;
import io.grpc.examples.CalculatorOuterClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

/**
 * Created by lfwang on 2016/11/7.
 */
@Service
public class CalculatorClient {

    @Autowired
    private ManagedChannel managedChannel;

    public double add(double x, double y) {
        CalculatorGrpc.CalculatorFutureStub calculatorFutureStub = CalculatorGrpc.newFutureStub(managedChannel);
        CalculatorOuterClass.CalculatorRequest calculatorRequest = CalculatorOuterClass.CalculatorRequest.newBuilder()
                .setNumber1(x).setNumber2(y).setOperation(CalculatorOuterClass.CalculatorRequest.OperationType.ADD)
                .build();

        try {
            return calculatorFutureStub.calculate(calculatorRequest).get().getResult();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        return 0.0;
    }
}
