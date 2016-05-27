package com.jpa.query.repository;

import com.jpa.query.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * Created by Lingfeng on 2015/9/30.
 *
 * JpaSpecificationExecutor不属于Repository体系，实现一组JPA Criteria查询相关的方法
 * 使用JpaSpecificationExecutor同时以autowired方式实现该类时，必须添加使用Repository的类
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {
}
