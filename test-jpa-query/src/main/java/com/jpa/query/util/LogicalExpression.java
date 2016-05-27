package com.jpa.query.util;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 逻辑条件表达式用于复杂条件时使用
 * Created by Lingfeng on 2015/12/11.
 */
public class LogicalExpression implements Criterion {

    private Criterion[] criterions; // 逻辑表达式中包含的表达式
    private Operator operator; // 计算符

    public LogicalExpression(Criterion[] criterions, Operator operator) {
        this.criterions = criterions;
        this.operator = operator;
    }

    @Override
    public Predicate createPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> predicateList = new ArrayList<>();

        for (Criterion criterion : criterions) {
            predicateList.add(criterion.createPredicate(root, query, builder));
        }

        switch (operator) {
            case AND:
                return builder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            case OR:
                return builder.or(predicateList.toArray(new Predicate[predicateList.size()]));
            default:
                return null;
        }
    }
}
