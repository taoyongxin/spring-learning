package com.soft1851.spring.ioc.config;

import com.soft1851.spring.ioc.entity.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Tao
 * @version 1.0
 * @ClassName AppConfig
 * @Description TODO
 * @date 2020-03-17 14:30
 **/
@Configuration
public class AppConfig {
    @Bean
    public Book book(){
        return new Book();
    }
}
