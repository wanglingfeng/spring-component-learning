package com.rest;

import com.rest.test.SimpleRestClient;
import com.rest.test.controller.domain.TestInfo;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.*;

/**
 * Created by Lingfeng on 2016/3/22.
 */
public class RestTemplateTest {

    @Test
    public void getTest() {
        final String xmlUri = "http://localhost:8080/employees.xml";
        String xmlResult = SimpleRestClient.getClient().getForObject(xmlUri, String.class);
        System.out.println(xmlResult);

        final String jsonUri = "http://localhost:8080/employees.json";
        String jsonResult = SimpleRestClient.getClient().getForObject(jsonUri, String.class);
        System.out.println(jsonResult);

        final String httpHeaderUri = "http://localhost:8080/employees";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);
        ResponseEntity<String> httpHeaderResult = SimpleRestClient.getClient()
                .exchange(httpHeaderUri, HttpMethod.GET, entity, String.class);
        System.out.println(httpHeaderResult);
    }

    @Test
    public void withCustomizedHeaders() {
        String url = "";
        HttpMethod method = HttpMethod.POST;
        String usernameAndPasswordEncoded = "";

        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.set("Authorization", "Basic "
                + usernameAndPasswordEncoded);

        MultiValueMap<String, String> postParams = new LinkedMultiValueMap<>();
        postParams.add("firstName", "wang");
        postParams.add("lastName", "joseph");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(postParams, requestHeaders);

        ResponseEntity<String> result = SimpleRestClient.getClient().exchange(url, method, requestEntity, String.class);

        System.out.println(result);
    }

    @Test
    public void getAllJson() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());

        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setMessageConverters(messageConverters);

        final String uri = "http://localhost:8080/all_json";

        TestInfo info = new TestInfo("asd", "123");

        /*TestInfo result = restTemplate.postForObject(uri, info, TestInfo.class);*/
        HttpEntity<TestInfo> requestEntity = new HttpEntity<>(info);
        ResponseEntity<TestInfo> response = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, TestInfo.class);
        TestInfo result = response.getBody();

        System.out.println(result);
    }

    @Test
    public void getAll() {
        RestTemplate restTemplate = new RestTemplate();
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setReadTimeout(5000);
        requestFactory.setConnectTimeout(5000);

        List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
        messageConverters.add(new StringHttpMessageConverter(Charset.forName("UTF-8")));
        messageConverters.add(new FormHttpMessageConverter());
        messageConverters.add(new MappingJackson2HttpMessageConverter());


        restTemplate.setRequestFactory(requestFactory);
        restTemplate.setMessageConverters(messageConverters);

        final String uri = "http://localhost:8080/all_form";

        MultiValueMap<String, Object> postParams = new LinkedMultiValueMap<>();
        postParams.add("username", "asd");
        postParams.add("password", "123");

        Map result = restTemplate.postForObject(uri, postParams, Map.class);

        System.out.println(result);

        /*ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode node = mapper.readTree(result);
            System.out.println(node.get("username"));
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    @Test
    public void testPost() {
        final String uri = "http://localhost:8080/all_form";

        Map<String, String> params = new HashMap<>();
        params.put("username", "asd");
        params.put("password", "123");

        String result = post(uri, params);
        System.out.println(result);
    }

    public static String post(String url, Map<String, String> paramsMap) {
        CloseableHttpClient client = HttpClients.createDefault();
        String responseText = "";
        CloseableHttpResponse response = null;
        try {
            HttpPost method = new HttpPost(url);
            if (paramsMap != null) {
                List<NameValuePair> paramList = new ArrayList<>();
                for (Map.Entry<String, String> param : paramsMap.entrySet()) {
                    NameValuePair pair = new BasicNameValuePair(param.getKey(), param.getValue());
                    paramList.add(pair);
                }
                method.setEntity(new UrlEncodedFormEntity(paramList, "UTF-8"));
            }
            response = client.execute(method);
            org.apache.http.HttpEntity entity = response.getEntity();
            if (entity != null) {
                responseText = EntityUtils.toString(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return responseText;
    }
}
