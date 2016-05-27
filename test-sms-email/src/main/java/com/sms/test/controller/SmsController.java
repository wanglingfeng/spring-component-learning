package com.sms.test.controller;

import com.sms.test.service.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Lingfeng on 2016/4/15.
 */
@RestController
@RequestMapping("/sms")
public class SmsController {

    @Autowired
    private SmsSender smsSender;

    @RequestMapping(value = "/send", method = {RequestMethod.GET, RequestMethod.POST})
    public String send(@RequestParam String mobile) {
        return smsSender.send(mobile);
    }
}
