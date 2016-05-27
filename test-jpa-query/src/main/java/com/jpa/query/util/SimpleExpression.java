package com.jpa.query.util;

import javax.persistence.criteria.*;

/**
 * 简单条件表达式实现
 * Created by Lingfeng on 2015/12/11.
 */
public class SimpleExpression implements Criterion {

    private String fieldName; // 属性名称
    private Object value; // 对应的值
    private Operator operator; // 计算符

    protected SimpleExpression(String fieldName, Object value, Operator operator) {
        this.fieldName = fieldName;
        this.value = value;
        this.operator = operator;
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public Predicate createPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        Path expression;

        if (fieldName.contains(".")) {
            String[] names = fieldName.split("\\.");

            expression = root.get(names[0]);

            for (int i = 1; i < names.length; i++) {
                expression = expression.get(names[i]);
            }
        } else {
            expression = root.get(fieldName);
        }

        switch (operator) {
            case EQ:
                return builder.equal(expression, value);
            case NE:
                return builder.notEqual(expression, value);
            case LIKE:
                return builder.like((Expression<String>) expression, "%" + value + "%");
            case LT:
                return builder.lessThan(expression, (Comparable) value);
            case GT:
                return builder.greaterThan(expression, (Comparable) value);
            case LTE:
                return builder.lessThanOrEqualTo(expression, (Comparable) value);
            case GTE:
                return builder.greaterThanOrEqualTo(expression, (Comparable) value);
            default:
                return null;
        }
    }
}
