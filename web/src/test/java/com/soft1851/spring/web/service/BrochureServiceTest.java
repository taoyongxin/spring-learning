package com.soft1851.spring.web.service;

import com.soft1851.spring.web.config.SpringDataSourceConfig;
import com.soft1851.spring.web.spider.JueJinXiaoCeSpider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringDataSourceConfig.class})
@WebAppConfiguration("src/main/resources")
public class BrochureServiceTest {

    @Resource
    private BrochureService brochureService;
    @Test
    public void queryAll() {
        System.out.println(brochureService.queryAll());
    }

    @Test
    public void batchInsert() {
        for (int i =1;i<5;i++){
            int[] ints= brochureService.batchInsert(JueJinXiaoCeSpider.getBrochure(i));
        }
    }
}