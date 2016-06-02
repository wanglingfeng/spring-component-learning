package org.netflix.learning.feign.client.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.netflix.learning.feign.client.service.StoreClient;
import org.netflix.learning.feign.client.service.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * Created by Lingfeng on 2016/6/1.
 */
@RestController
@RequestMapping("/client/stores")
public class StoreClientController {

    @Autowired
    private StoreClient storeClient;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getStoresFallback")
    public List<Store> all() {
        List<Store> items = storeClient.getStores();
        Store item = new Store();
        item.setName("new 新东西");
        item.setCreatedAt(new Date());
        items.add(item);

        return items;
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "getStoreFallback")
    public Store one(@PathVariable String id) {
        return storeClient.getStore(id);
    }

    /**
     * fallback针对的是整个方法返回结果的替换，而不是发生网络请求的地方进行替换
     * 替换的是all方法的返回值，而不是storeClient.getStores()方法的返回值
     *
     * @return
     */
    private List<Store> getStoresFallback() {
        Store item = new Store();
        item.setName("fallback");
        item.setCreatedAt(new Date());

        return Collections.singletonList(item);
    }

    private Store getStoreFallback(String id) {
        Store item = new Store();
        item.setName(id + ": fallback");
        item.setCreatedAt(new Date());

        return item;
    }
}
