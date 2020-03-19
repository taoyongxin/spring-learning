package com.soft1851.spring.orm.dao.impl;

import com.soft1851.spring.orm.dao.PostAnnotatedDao;
import com.soft1851.spring.orm.entity.Post;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName PostAnnotatedDaoImpl
 * @Description TODO
 * @date 2020-03-19 14:31
 **/
@Component
public class PostAnnotatedDaoImpl implements PostAnnotatedDao {
    private  JdbcTemplate jdbcTemplate;

    public PostAnnotatedDaoImpl(org.springframework.jdbc.core.JdbcTemplate jdbcTemplate) {
        this.setJdbcTemplate(jdbcTemplate);
    }
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public int insert(Post post) {
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        Object[] args = {post.getForumId(), post.getTitle(),
                post.getContent(), post.getThumbnail(), post.getPostTime()};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public int[] batchInsert(List<Post> posts) {
        final List<Post> postList = posts;
        String sql = "INSERT INTO t_post VALUES (NULL,?,?,?,?,?)";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,postList.get(i).getForumId());
                preparedStatement.setString(2,postList.get(i).getTitle());
                preparedStatement.setString(3,postList.get(i).getContent());
                preparedStatement.setBytes(4,postList.get(i).getThumbnail());
                preparedStatement.setString(5,postList.get(i).getPostTime().toString());
            }
            @Override
            public int getBatchSize() {
                return postList.size();
            }
        });
    }

    @Override
    public int delete(int postId) {
        String sql = "DELETE FROM t_post WHERE post_id = ?";
        Object[] args = {postId};
        return jdbcTemplate.update(sql,args);
    }

    @Override
    public Post get(int postId) {
        String sql = "SELECT * FROM t_post WHERE post_id = ? ";
        Object[] args = {postId};
        return jdbcTemplate.queryForObject(sql,args,new BeanPropertyRowMapper<>(Post.class));
    }

    @Override
    public List<Post> getAllByKey(String key1) {
        String sql = "SELECT * FROM t_post WHERE title LIKE '%"+key1+"%'";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Post.class));
    }


    @Override
    public int update(Post post) {
        String sql = "UPDATE t_post SET title = ? WHERE post_id = ? ";
        Object[] args = {post.getTitle(),post.getPostId()};
        return jdbcTemplate.update(sql,args);
    }



    @Override
    public int[] batchDelete(int[] posts) {
        String sql = "DELETE FROM t_post WHERE post_id = ? ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                preparedStatement.setInt(1,posts[i]);
            }

            @Override
            public int getBatchSize() {
                return posts.length;
            }
        });
    }

    @Override
    public int statisticsPost(int forumId) {
        String sql = "SELECT * FROM t_post WHERE forum_id = ? ";
        Object[] args = {forumId};
        List<Post> postList = jdbcTemplate.query(sql,args, new BeanPropertyRowMapper<>(Post.class));
        return postList.size();
    }
}
