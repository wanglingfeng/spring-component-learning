package com.jpa.query.util;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * 条件表达式接口
 * Created by Lingfeng on 2015/12/11.
 */
public interface Criterion {

    enum Operator {
        EQ, NE, LIKE, GT, LT, GTE, LTE, AND, OR
    }

    Predicate createPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder);
}
