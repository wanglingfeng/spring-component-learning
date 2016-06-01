package org.netflix.learning.feign.client.service;

import org.netflix.learning.feign.client.HelloClientApplication;
import org.netflix.learning.feign.client.service.domain.Store;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by Lingfeng on 2016/6/1.
 */
@FeignClient(name = "HelloServer")
public interface StoreClient {

    @RequestMapping(value = "/stores", method = RequestMethod.GET)
    List<Store> getStores();

    @RequestMapping(value = "/stores/{id}", method = RequestMethod.GET)
    Store getStore(@PathVariable("id") String id);
}
