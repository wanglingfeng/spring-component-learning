package org.netflix.learning.feign.client.service.domain;

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
