package com.sms.test.service.impl;

import com.sms.test.service.SmsSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Lingfeng on 2016/4/15.
 */
@Service
public class SmsSenderImpl implements SmsSender {

    private static final String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public String send(String mobile) {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("apikey", "b6715c090207776b36285db9aff041da");
        params.add("mobile", mobile);
        params.add("text", "【集吉运】您的验证码是1208");

        String result = restTemplate.postForObject(URI_SEND_SMS, params, String.class);

        return result;
    }
}
