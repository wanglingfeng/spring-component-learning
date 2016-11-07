package org.joseph.grpc.demo;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.examples.GreeterGrpc;
import io.grpc.examples.GreeterOuterClass;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by lfwang on 2016/11/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ServerApplication.class}, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class ServerTests {

    private ManagedChannel channel;

    @Rule
    public OutputCapture outputCapture = new OutputCapture();

    @Before
    public void setup() {
        channel = ManagedChannelBuilder.forAddress("localhost", 6560)
                .usePlaintext(true).build();
    }

    @After
    public void tearDown() {
        channel.shutdown();
    }

    @Test
    public void simpleGreeting() throws ExecutionException, InterruptedException {
        String name = "joseph";

        GreeterGrpc.GreeterFutureStub greeterFutureStub = GreeterGrpc.newFutureStub(channel);
        GreeterOuterClass.HelloRequest helloRequest = GreeterOuterClass.HelloRequest.newBuilder()
                .setName(name).build();
        String reply = greeterFutureStub.sayHello(helloRequest).get().getMessage();

        assertNotNull(reply);
        assertTrue(String.format("Reply should contain name '%s'", name), reply.contains(name));
    }
}
