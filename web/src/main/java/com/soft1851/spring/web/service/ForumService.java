package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Forum;

import java.util.List;

/**
 * @author Tao
 */
public interface ForumService {
    /**
     * 查询所有Forum
     * @return
     */
    List<Forum> selectAll();

    /**
     * 新增forum
     * @param forum
     * @return
     */
    int insert(Forum forum);
    /**
     * 通过id查询
     * @param forumId
     * @return
     */
    Forum selectById(Integer forumId);

    /**
     * 根据id删除
     * @param forumId
     * @return
     */
    int deleteById(Integer forumId);
    /**
     * 批量删除
     * @param forumId
     * @return
     */
    int batchDelete(String forumId);

    /**
     * 修改
     * @param forum
     * @return
     */
    int update(Forum forum);

}
