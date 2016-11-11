package com.sms;

/*import com.sms.test.SMSApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;*/

/**
 * Created by Lingfeng on 2016/4/5.
 */
/*@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SMSApplication.class)
public class SMSTest {

    private static final String URI_SEND_SMS = "https://sms.yunpian.com/v2/sms/single_send.json";

    private static final String URI_SEND_VOICE = "https://voice.yunpian.com/v2/voice/send.json";

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void sendSMS() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("apikey", "b6715c090207776b36285db9aff041da");
        params.add("mobile", "15021489117");
        params.add("text", "【集吉运】您的验证码是1208");

        String result = restTemplate.postForObject(URI_SEND_SMS, params, String.class);
        System.out.println(result);
    }

    @Test
    public void sendVoice() {
        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("apikey", "b6715c090207776b36285db9aff041da");
        params.add("mobile", "15021489117");
        params.add("code", "1208");

        String result = restTemplate.postForObject(URI_SEND_VOICE, params, String.class);
        System.out.println(result);
    }
}*/
