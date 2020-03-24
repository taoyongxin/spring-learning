//package com.soft1851.spring.web.dao.impl;
//
//
//import com.soft1851.spring.web.dao.ForumDao;
//import com.soft1851.spring.web.entity.Forum;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BatchPreparedStatementSetter;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * @author Tao
// * @version 1.0
// * @ClassName ForumDaoImpl
// * @Description TODO
// * @date 2020-03-17 13:11
// * Spring JDBC的xml配置版
// **/
//@Repository
//public class ForumDaoImpl implements ForumDao {
//    @Autowired
//    private JdbcTemplate jdbcTemplate;
//
//    @Override
//    public int insert(Forum forum) {
//        String sql = "INSERT INTO t_forum VALUES (NULL,?) ";
//        Object[] args = {forum.getForumName()};
//        return jdbcTemplate.update(sql,args);
//    }
//
//    @Override
//    public int[] batchInsert(List<Forum> forums) {
//        final  List<Forum> forumList = forums;
//        String sql = "INSERT INTO t_forum VALUES (NULL,?)";
//        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
//                preparedStatement.setString(1,forumList.get(i).getForumName());
//            }
//            @Override
//            public int getBatchSize() {
//                return forumList.size();
//            }
//        });
//    }
//
//    @Override
//    public int batchDelete(String forumId) {
//        String[] p = new String[100];
//        Integer[] b = new Integer[100];
//        int i,k = 0;
//        String string = forumId;
//        for (i = 0; string.length() != 0; i++) {
//            p[i] = string.substring(0, string.indexOf(","));
//            b[i] = Integer.valueOf(p[i]);
//            delete(b[i]);
//            k = string.indexOf(",");
//            string = string.substring(k + 1, string.length());
//        }
//        System.out.println(i);
//        return i;
//    }
//
//    @Override
//    public int delete(int forumId) {
//        String sql = "DELETE FROM t_forum WHERE forum_id = ?";
//        Object[] args = {forumId};
//        return jdbcTemplate.update(sql,args);
//    }
//
//    @Override
//    public Forum get(int forumId) {
//        String sql = "SELECT * FROM t_forum WHERE forum_id = ? ";
//        Object[] args = {forumId};
//        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Forum.class));
//    }
//
//    @Override
//    public int update(Forum forum) {
//        String sql = "UPDATE t_forum SET forum_name = ? WHERE forum_id = ? ";
//        Object[] args = {forum.getForumName(),forum.getForumId()};
//        return jdbcTemplate.update(sql,args);
//    }
//
//    @Override
//    public List<Forum> seletcAll() {
//        String sql = "SELECT * FROM t_forum ";
//        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Forum.class));
//    }
//}