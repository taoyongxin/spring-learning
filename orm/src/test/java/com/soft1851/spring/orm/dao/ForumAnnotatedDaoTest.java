package com.soft1851.spring.orm.dao;

import com.soft1851.spring.orm.config.SpringDataSourceConfig;
import com.soft1851.spring.orm.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
public class ForumAnnotatedDaoTest {

    @Autowired
    private ForumAnnotatedDao forumAnnotatedDao;

    @Test
    public void insert() {
        Forum forum = Forum.builder().forumName("测试论坛").build();
        int n = forumAnnotatedDao.insert(forum);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        Forum[] forums = {Forum.builder().forumName("测试论坛1").build(),
                Forum.builder().forumName("测试论坛2").build(),
                Forum.builder().forumName("测试论坛3").build()
        };
        List<Forum> forumList = Arrays.asList(forums);
        int[] rows = forumAnnotatedDao.batchInsert(forumList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n = forumAnnotatedDao.delete(4);
        assertEquals(1,n);
    }

    @Test
    public void get() {
        Forum forum = forumAnnotatedDao.get(3);
        assertNotNull(forum);
        System.out.println(forum);
    }

    @Test
    public void update() {
        Forum forum = forumAnnotatedDao.get(2);
        forum.setForumName("测试论坛修改的新名称");
        int n = forumAnnotatedDao.update(forum);
        assertEquals(1,n);

    }

    @Test
    public void seletcAll() {
        List<Forum> forums = forumAnnotatedDao.seletcAll();
        assertEquals(6,forums.size());
        System.out.println(forums);
    }
}