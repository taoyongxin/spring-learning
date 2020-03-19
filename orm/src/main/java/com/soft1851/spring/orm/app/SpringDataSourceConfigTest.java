package com.soft1851.spring.orm.app;

import com.soft1851.spring.orm.config.SpringDataSourceConfig;
import com.soft1851.spring.orm.dao.ForumAnnotatedDao;
import com.soft1851.spring.orm.dao.PostAnnotatedDao;
import com.soft1851.spring.orm.entity.Forum;
import com.soft1851.spring.orm.entity.Post;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SpringDataSourceConfigTest
 * @Description TODO
 * @date 2020-03-19 9:52
 **/
public class SpringDataSourceConfigTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(SpringDataSourceConfig.class);

        ctx.scan("com.soft1851.spring.orm.config");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
        System.out.println(jdbcTemplate);

        ForumAnnotatedDao forumAnnotatedDao = (ForumAnnotatedDao) ctx.getBean("forumAnnotatedDao");
        List<Forum> forums = forumAnnotatedDao.seletcAll();
        System.out.println(forums);

        PostAnnotatedDao postAnnotatedDao = (PostAnnotatedDao) ctx.getBean("postAnnotatedDao");
        Post posts = postAnnotatedDao.get(3);
        System.out.println(posts);
    }
}