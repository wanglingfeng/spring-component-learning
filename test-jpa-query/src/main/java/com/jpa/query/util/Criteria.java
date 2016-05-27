package com.jpa.query.util;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * 定义一个查询条件容器
 * Created by Lingfeng on 2015/12/11.
 */
public class Criteria<T> implements Specification<T> {

    private List<Criterion> criterionList = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if (!criterionList.isEmpty()) {
            List<Predicate> predicateList = new ArrayList<>();

            for (Criterion criterion : criterionList) {
                Predicate predicate = criterion.createPredicate(root, query, cb);

                if (null != predicate) {
                    predicateList.add(predicate);
                }
            }

            // 将所有条件用and联合起来
            if (!predicateList.isEmpty()) {
                return cb.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        }

        return cb.conjunction();
    }

    /**
     * 添加简单条件表达式
     * @param criterion
     */
    public void add(Criterion criterion) {
        if (null != criterion) criterionList.add(criterion);
    }
}
