//package com.soft1851.spring.web.service.impl;
//
//import com.soft1851.spring.web.dao.ForumDao;
//import com.soft1851.spring.web.entity.Forum;
//import com.soft1851.spring.web.service.ForumService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
///**
// * @author Tao
// * @version 1.0
// * @ClassName ForumServiceImpl
// * @Description TODO
// * @date 2020-03-20 11:22
// **/
//@Service
//public class ForumServiceImpl implements ForumService {
//    @Autowired
//    private ForumDao forumDao;
//
//    @Override
//    public List<Forum> selectAll() {
//        return forumDao.seletcAll();
//    }
//
//    @Override
//    public int insert(Forum forum) {
//        Forum forum1 = Forum.builder().forumId(forum.getForumId()).forumName(forum.getForumName()).build();
////        forumDao.insert(forum1);
//        return forumDao.insert(forum1);
//    }
//
//    @Override
//    public Forum selectById(Integer forumId) {
//        return forumDao.get(forumId);
//    }
//
//    @Override
//    public int deleteById(Integer forumId) {
//        return forumDao.delete(forumId);
//    }
//
//    @Override
//    public int batchDelete(String forumId) {
//        System.out.println(forumId);
//        return forumDao.batchDelete(forumId);
//    }
//
//    @Override
//    public int update(Forum forum) {
//        System.out.println(forum);
//        return forumDao.update(forum);
//    }
//
//
//}
