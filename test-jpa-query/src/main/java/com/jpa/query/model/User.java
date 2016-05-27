package com.jpa.query.model;

import com.jpa.query.repository.LocalDateTimePersistenceConverter;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * Created by Lingfeng on 2015/9/30.
 */
@Entity(name = "user_info")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String name;

//    @Temporal(TemporalType.TIMESTAMP)
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Convert(converter = LocalDateTimePersistenceConverter.class)
    private LocalDateTime createTime;

    public User() {

    }

    public User(String name, LocalDateTime createTime) {
        this.name = name;
        this.createTime = createTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "User [id = "+ this.id + ", name = " + this.name + ", createTime = " + this.createTime +"]";
    }
}
