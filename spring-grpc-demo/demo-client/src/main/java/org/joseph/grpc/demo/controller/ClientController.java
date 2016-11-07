package org.joseph.grpc.demo.controller;

import org.joseph.grpc.demo.client.CalculatorClient;
import org.joseph.grpc.demo.client.GreeterClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lfwang on 2016/11/7.
 */
@RestController
@RequestMapping("/")
public class ClientController {

    @Autowired
    private GreeterClient greeterClient;

    @Autowired
    private CalculatorClient calculatorClient;

    @RequestMapping(value = "/im/{name}")
    public String hello(@PathVariable String name) {
        return greeterClient.sayHello(name);
    }

    @RequestMapping(value = "/add")
    public double add(@RequestParam double x, @RequestParam double y) {
        return calculatorClient.add(x, y);
    }
}
