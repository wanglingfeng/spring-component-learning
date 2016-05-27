package com.jpa.query.test;

import com.jpa.query.TestApplication;
import com.jpa.query.model.User;
import com.jpa.query.repository.UserRepository;
import com.jpa.query.util.Criteria;
import com.jpa.query.util.Restrictions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.criteria.Predicate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by Lingfeng on 2015/9/30.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestApplication.class)
@WebAppConfiguration
@ActiveProfiles("dev")
@DirtiesContext
public class QueryMain {

    @Autowired
    UserRepository userRepository;

    @Test
    public void query() {
        findUserPage("a", null, new Date(), null, null);
    }

    @Test
    public void insert() {
        List<User> users = Arrays.asList(
                new User("qwe", LocalDateTime.parse("2015-12-08 20:20:20", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                new User("asd", LocalDateTime.parse("1998-12-12 12:12:12", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))),
                new User("qqq", LocalDateTime.parse("2000-01-01 01:01:01", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))));

        userRepository.save(users);
    }

    /**
     * 分页查询user信息
     *
     * 查询条件：
     * @param nameLike 名称(模糊查询)
     * @param stime 开始时间
     * @param etime 结束时间
     *
     * 分页条件：
     * @param pageNum 页码
     * @param limit 每页条数限制
     */
    private void findUserPage(String nameLike, Date stime, Date etime,
                              Integer pageNum, Integer limit) {

        // 共通动态查询
        Criteria<User> userCriteria = new Criteria<>();

        userCriteria.add(Restrictions.like("name", nameLike, true));
        userCriteria.add(Restrictions.gte("createTime", stime, true));
        userCriteria.add(Restrictions.lte("createTime", etime, true));

        Page<User> page = userRepository.findAll(
                userCriteria, buildPageRequest(pageNum, limit));

//        Page<User> page = userRepository.findAll(
//                buildSpecification(nameLike, stime, etime),
//                buildPageRequest(pageNum, limit));

        for (User user : page.getContent()) {
            System.out.println(user.toString());
        }
    }

    private Specification<User> buildSpecification(String name, Date stime, Date etime) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (null != name && !"".equals(name)) {
                predicates.add(cb.like(root.get("name"), "%" + name + "%"));
            }

            if (null != stime) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("createTime"), stime));
            }

            if (null != etime) {
                predicates.add(cb.lessThanOrEqualTo(root.get("createTime"), etime));
            }

            // 多表查询
//            ListJoin<User, Object> listJoin = root.join(root.getModel().getList("list", Object.class), JoinType.LEFT);
//            predicates.add(cb.equal(listJoin.get("listId"), "asd"));

            if (predicates.isEmpty()) {
                return cb.conjunction();
            } else {
                return cb.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };
    }

    private PageRequest buildPageRequest(Integer page, Integer limit) {
        if (null == page) {
            page = 1;
        }
        if (null == limit) {
            limit = 5;
        }

        Sort sort = new Sort(Sort.Direction.valueOf("DESC"), "createTime");

        return new PageRequest(page - 1, limit, sort);
    }
}
