package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Post;

import java.util.List;

/**
 * @author Tao
 */
public interface PostDao {
    /**
     * 新增post
     * @param post
     * @return
     */
    int insert(Post post);

    /**
     * 批量新增post
     * @param posts
     * @return
     */
    int[] batchInsert(List<Post> posts);

    /**
     * 根据id删除post
     * @param postId
     * @return
     */
    int delete(int postId);

    /**
     * 根据id查询
     * @param postId
     * @return
     */
    Post get(int postId);

    /**
     * 根据关键词查询post
     * @param key1
     * @return
     */
    List<Post> getAllByKey(String key1);
    /**
     * 修改post
     * @param post
     * @return
     */
    int update(Post post);


    /**
     * 批量删除
     * @param posts
     * @return
     */
    int batchDelete(int[] posts);

    /**
     * 统计某个论坛的帖子的总数
     * @param forumId
     * @return
     */
    int statisticsPost(int forumId);
}
