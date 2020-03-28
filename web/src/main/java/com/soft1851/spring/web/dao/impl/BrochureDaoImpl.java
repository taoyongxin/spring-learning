package com.soft1851.spring.web.dao.impl;

import com.soft1851.spring.web.dao.BrochureDao;
import com.soft1851.spring.web.entity.Brochure;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName BrochureDaoImpl
 * @Description TODO
 * @date 2020-03-28 11:12
 **/
@Repository
public class BrochureDaoImpl implements BrochureDao {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int[] batchInsert(List<Brochure> brochures) {
        final List<Brochure> brochureList = brochures;
        String sql = "INSERT INTO t_brochure (title,`desc`, user_name, profile, price, last_section_count, buy_count,cover,avatar)" +
                "VALUES (?,?,?,?,?,?,?,?,?) ";
        return jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement preparedStatement, int i) throws SQLException {
                Brochure brochure = brochureList.get(i);
                preparedStatement.setString(1, brochure.getTitle());
                preparedStatement.setString(2, brochure.getDesc());
                preparedStatement.setString(3, brochure.getUserName());
                preparedStatement.setString(4, brochure.getProfile());
                preparedStatement.setDouble(5,brochure.getPrice());
                preparedStatement.setInt(6, brochure.getLastSectionCount());
                preparedStatement.setInt(7, brochure.getBuyCount());
                preparedStatement.setString(8, brochure.getCover());
                preparedStatement.setString(9, brochure.getAvatar());
            }
            @Override
            public int getBatchSize() {
                return brochureList.size();
            }
        });
    }

    @Override
    public List<Brochure> selectAll() {
        String sql = "SELECT * FROM t_brochure ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Brochure.class));
    }
}
