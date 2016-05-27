package com.rest.test.controller;

import com.rest.test.controller.domain.TestInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lingfeng on 2016/3/22.
 */
@RestController
public class TestController {

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_XML_VALUE, method = RequestMethod.GET)
    public String getAllEmployeesXML() {

        return "XML All Employees";
    }

    @RequestMapping(value = "/employees", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public String getAllEmployeesJSON() {

        return "JSON All Employees";
    }


    @RequestMapping(value = "/all_json", method = RequestMethod.POST)
    public TestInfo allJson(@RequestBody TestInfo info) {
        System.out.println(info.getUsername());
        System.out.println(info.getPassword());

        return new TestInfo("hello", "it's me");
    }

    /**
     * PS: 参数from表单形式传入，结果json格式返回
     * @param info
     * @return
     */
    @RequestMapping(value = "/all_form", method = RequestMethod.POST)
    public TestInfo allForm(TestInfo info) {
        System.out.println(info.getUsername());
        System.out.println(info.getPassword());

        return new TestInfo("hello", "哈喽");
    }
}
