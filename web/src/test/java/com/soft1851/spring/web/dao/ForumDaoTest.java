package com.soft1851.spring.web.dao;


import com.soft1851.spring.web.entity.Forum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class ForumDaoTest {
    @Autowired
    private ForumDao forumDao;

    @Test
    public void selectAll(){
        List<Forum> forums = forumDao.seletcAll();
        System.out.println(forums);
    }
}