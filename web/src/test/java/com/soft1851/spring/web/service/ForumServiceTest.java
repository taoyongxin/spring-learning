package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumServiceTest {

    @Autowired
    private ForumService forumService;

    @Test
    public void selectAll() {
        List<Forum> forums = forumService.selectAll();
        System.out.println(forums);
    }

    @Test
    public void insert() {
        Forum forum = Forum.builder()
                .forumName("111")
                .build();
        forumService.insert(forum);
    }
}