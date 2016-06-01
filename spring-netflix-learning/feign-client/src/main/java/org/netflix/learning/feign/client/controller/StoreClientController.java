package org.netflix.learning.feign.client.controller;

import org.netflix.learning.feign.client.service.StoreClient;
import org.netflix.learning.feign.client.service.domain.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    public List<Store> all() {
        return storeClient.getStores();
    }

    @RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
    public Store one(@PathVariable String id) {
        return storeClient.getStore(id);
    }
}
