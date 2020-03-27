package com.soft1851.spring.web.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Tao
 * @version 1.0
 * @ClassName SpringDataSourceConfig
 * @Description TODO
 * @date 2020-03-26 10:16
 **/
@Configuration
@ComponentScan("com.soft1851.spring.web")
//数据源
@PropertySource("classpath:jdbc.properties")
//开始事务注解
@EnableTransactionManagement
public class SpringDataSourceConfig {

    @Value("${jdbc.driverClassName}")
    private String driverClassName;

    @Value("${jdbc.url}")
    private String jdbcUrl;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;
    /**
     * 数据链接地址池配置
     * @return druidDataSource
     */
    @Bean
    public DruidDataSource druidDataSource(){
        DruidDataSource druidDataSource = new DruidDataSource();
//        配置数据库基本的连接属性
        druidDataSource.setDriverClassName(driverClassName);
        druidDataSource.setUrl(jdbcUrl);
        druidDataSource.setUsername(username);
        druidDataSource.setPassword(password);
        //配置初始化大小/最小/最大
        druidDataSource.setInitialSize(1);
        druidDataSource.setMinIdle(1);
        druidDataSource.setMaxActive(20);
        //配置获取链接等待超时的时间
        druidDataSource.setMaxWait(60000);
        //配置间隔多久才进行一次检测,检测需要关闭的空闲连接,单位是毫秒
        druidDataSource.setTimeBetweenEvictionRunsMillis(60000);
        //配置一个链接在池中最小生存的时间,单位是毫秒
        druidDataSource.setMinEvictableIdleTimeMillis(300000);
        //禁止自动提交,实现事务管理
        druidDataSource.setDefaultAutoCommit(false);
        //设置连接池其用于处理事务集
        druidDataSource.setPoolPreparedStatements(true);
        return druidDataSource;
    }

    /**
     * JdbcTemplate模板配置
     * @return JdbcTemplate
     */
    @Bean
    public JdbcTemplate jdbcTemplate(DruidDataSource druidDataSource){
        return new JdbcTemplate(druidDataSource);
    }

    /**
     * 装配事务管理器
     * @param druidDataSource
     * @return
     */
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DruidDataSource druidDataSource){
        return new DataSourceTransactionManager(druidDataSource);
    }
}
