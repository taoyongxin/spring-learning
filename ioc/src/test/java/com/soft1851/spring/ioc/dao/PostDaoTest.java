package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PostDaoTest {

    @Autowired
    private PostDao postDao;
    @Test
    public void insert() {
        byte[] buffer=new byte[1024];
        Post post = Post.builder()
                .forumId(1)
                .title("测试标题")
                .content("测试内容")
                .thumbnail(buffer)
                .postTime(LocalDateTime.now())
                .build();
        int n = postDao.insert(post);
        assertEquals(1,n);
    }

    @Test
    public void batchInsert() {
        byte[] buffer=new byte[1024];
        Post[] posts = {Post.builder().forumId(2).title("测试帖子1")
                .content("测试内容1").thumbnail(buffer).postTime(LocalDateTime.now()).build(),

                Post.builder().forumId(2).title("测试帖子2")
                        .content("测试内容2").thumbnail(buffer).postTime(LocalDateTime.now()).build(),

                Post.builder().forumId(2).title("测试帖子3")
                        .content("测试内容3").thumbnail(buffer).postTime(LocalDateTime.now()).build()
        };
        List<Post> postList = Arrays.asList(posts);
        int[] rows = postDao.batchInsert(postList);
        assertEquals(3,rows.length);
    }

    @Test
    public void delete() {
        int n = postDao.delete(1);
        assertEquals(1,n);
    }

    @Test
    public void get() {
        Post post = postDao.get(2);
        assertNotNull(post);
    }

    @Test
    public void update() {
        Post post = postDao.get(2);
        post.setTitle("测试修改标题");
        int n = postDao.update(post);
        assertEquals(1,n);
    }

    @Test
    public void getAllByKey() {
        List<Post> postList = postDao.getAllByKey("测试修改");
        System.out.println(postList);
        assertEquals(3,postList.size());
    }

//    @Test
//    public void batchDelete() {
//        Post[] posts = {Post.builder().postId(2).build(),
//                Post.builder().postId(3).build()
//        };
//        List<Post> postList = Arrays.asList(posts);
//        int[] rows = postDao.batchDelete(postList);
//        assertEquals(2,rows.length);
//    }
}