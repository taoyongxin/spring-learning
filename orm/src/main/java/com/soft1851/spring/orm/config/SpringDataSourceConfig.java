package com.soft1851.spring.orm.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.soft1851.spring.orm.dao.ForumAnnotatedDao;
import com.soft1851.spring.orm.dao.PostAnnotatedDao;
import com.soft1851.spring.orm.dao.impl.ForumAnnotatedDaoImpl;
import com.soft1851.spring.orm.dao.impl.PostAnnotatedDaoImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SpringDataSourceConfig
 * @Description TODO
 * @date 2020-03-19 9:40
 **/
@Configuration
@ComponentScan("com.soft1851.spring.orm")
public class SpringDataSourceConfig {
    @Bean
    public  DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        druidDataSource.setUrl("jdbc:mysql://localhost:3306/db_class?useUnicode=true&characterEncoding=utf8&useSSL=false&autoReconnect=true");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("root");
//        配置初始化大小、最小、最大
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
//        配置获取连接等待超时的时间
        druidDataSource.setMaxWait(60000);
//        配置一个连接在池中最小生存的时间，单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
//        禁止自动调焦，实现事务管理
//        druidDataSource.setDefaultAutoCommit(false);
//        设置连接池启用预处理事物集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    @Bean
    public ForumAnnotatedDao forumAnnotatedDao(JdbcTemplate jdbcTemplate){
        return new ForumAnnotatedDaoImpl(jdbcTemplate);
    }
    @Bean
    public PostAnnotatedDao postAnnotatedDao(JdbcTemplate jdbcTemplate){
        return new PostAnnotatedDaoImpl(jdbcTemplate);
    }

}
