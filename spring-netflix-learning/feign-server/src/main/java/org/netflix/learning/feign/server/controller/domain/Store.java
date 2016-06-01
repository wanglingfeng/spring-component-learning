package org.netflix.learning.feign.server.controller.domain;

import lombok.Data;

import java.util.Date;

/**
 * Created by Lingfeng on 2016/6/1.
 */
@Data
public class Store {

    private String name;
    private Date createdAt;
}
