package org.netflix.learning.feign.server.controller;

import org.netflix.learning.feign.server.controller.domain.Store;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Lingfeng on 2016/6/1.
 */
@RestController
@RequestMapping("/stores")
public class StoreController {

    @RequestMapping(method = RequestMethod.GET)
    public List<Store> stores() {
        List<Store> items = new ArrayList<>();
        Store item = new Store();
        item.setName("test");
        item.setCreatedAt(new Date());
        items.add(item);

        item = new Store();
        item.setName("周杰伦");
        item.setCreatedAt(new Date());
        items.add(item);

        return items;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Store store(@PathVariable String id) {
        Store item = new Store();
        item.setName(id + " test one");
        item.setCreatedAt(new Date());

        return item;
    }
}
