package com.soft1851.spring.ioc.dao;

import com.soft1851.spring.ioc.entity.Forum;

import java.util.List;

/**
 * @author Tao
 */
public interface ForumDao {
    /**
     * 新增Forum
     * @param forum
     * @return
     */
    int insert(Forum forum);

    /**
     * 批量新增Forum
     * @param forums
     * @return
     */
    int[] batchInsert(List<Forum> forums);

    /**
     * 根据id删除forum
     * @param forumId
     * @return
     */
    int delete(int forumId);

    /**
     * 根据id查询
     * @param forumId
     * @return
     */
    Forum get(int forumId);

    /**
     * 修改Forum
     * @param forum
     * @return
     */
    int update(Forum forum);


    /**
     * 查看所有论坛信息
     * @return
     */
    List<Forum> seletcAll();
}
