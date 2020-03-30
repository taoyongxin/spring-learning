package com.soft1851.spring.mybatis.service;

import com.soft1851.spring.mybatis.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ForumServiceTest {
    @Resource
    private ForumService forumService;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("测试论坛").build();
        forumService.insert(forum);
    }

    @Test
    public void delete() {
        forumService.delete(12);
    }

    @Test
    public void update() {
        Forum forum = Forum.builder().forumId(25).forumName("测试修改").build();
        forumService.update(forum);
    }

    @Test
    public void selectAll() {
        List<Forum> forums = forumService.selectAll();
        System.out.println(forums);
    }

    @Test
    public void selectForumById() {
        Forum forum = forumService.selectForumById(15);
        System.out.println(forum);
    }
}