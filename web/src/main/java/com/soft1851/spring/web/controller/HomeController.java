package com.soft1851.spring.web.controller;

import com.soft1851.spring.web.entity.Book;
import com.soft1851.spring.web.entity.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName HomeController
 * @Description TODO
 * @date 2020-03-24 9:46
 **/
@Controller
public class HomeController {
    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("message","Hello Spring MVC");
        Book[] books = {
                new Book(1,"python","https://img.alicdn.com/imgextra/i4/3161150069/TB2uGEQHbuWBuNjSszgXXb8jVXa_!!3161150069.jpg_60x60q90.jpg"),
                new Book(2,"web","https://img.alicdn.com/imgextra/i4/1614846122/TB22EwVa3HqK1RjSZFEXXcGMXXa_!!1614846122.png_60x60q90.jpg"),
                new Book(3,"c++","https://img.alicdn.com/imgextra/i3/TB1eP5IJVXXXXctXpXXXXXXXXXX_!!2-item_pic.png_60x60q90.jpg")
        };
        List<Book> bookList = Arrays.asList(books);
        model.addAttribute("bookList",bookList);
        return "home";
    }

    @GetMapping("recommend")
    public String recommend(Model model){
        Topic[] topics = {
                new Topic(1,"https://cdn.sspai.com/article/8bee3b68-eb0f-6f53-cdb9-b387f55a9f9a.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "派评 | 微信支持深色模式，近期值得关注的 17 款 App",
                        "https://cdn.sspai.com/2018/03/25/ce2a784deb3097acb6ee9d37ea0c13ea.jpg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "Noah_Choi","23小时前",25,16),
                new Topic(2,"https://cdn.sspai.com/article/f47dbeb4-3f64-86de-ca20-82cedf56621a.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "无限接近纸质笔记：学生党的 OneNote 使用心得",
                        "https://cdn.sspai.com/2020/03/07/939ce782046111eb35f0c6825ed8e5ff.jpeg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "daibor","03月11日",225,110),
                new Topic(3,"https://cdn.sspai.com/2020/02/26/7c00eacb7ac7a9b253352340cab287cb.png?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "想找免费好用的团队任务管理工具，Taskade 是个不错的选择",
                        "https://cdn.sspai.com/attachment/origin/2016/08/31/345261.jpg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "SpencerWoo","02月28日",48,5),
                new Topic(4,"https://cdn.sspai.com/article/8a511132-8fa8-a80b-1826-ef91d7dfe7b4.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "帮你分析心率数据，还能提供运动建议：HeartWatch 4",
                        "https://cdn.sspai.com/attachment/origin/2014/11/18/193975.jpeg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "Microhoo","1天前",17,15),
                new Topic(5,"https://cdn.sspai.com/article/7ce1302a-eadb-c43b-84fd-a7342c55a7a7.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "Eagle 1.11 更新: 全新分类工具、改善浏览逻辑，更人性化的素材管理软件",
                        "https://cdn.sspai.com/attachment/origin/2016/08/31/345261.jpg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "广陵止息","03月19日",25,17),
                new Topic(6,"https://cdn.sspai.com/article/18d39a42-385a-61a0-5e1c-e76d89308f14.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "与少数派一起过 8 岁生日，付费教程/正版软件限时放价！",
                        "https://cdn.sspai.com/2018/07/19/f20a0448401f5c9560cbef91a0dbcd05.png?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "福利派","03月13日",56,44),
                new Topic(7,"https://cdn.sspai.com/article/345e6e34-2525-a639-4d89-d3144cdf956a.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "好看又实用的暗色模式，不是「换个黑色界面」这么简单",
                        "https://cdn.sspai.com/2017/08/07/17d24c3a67f19359872ec6e54e386725.jpg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "WindsorDK","03月10日",90,70),
                new Topic(8,"https://cdn.sspai.com/article/021f9b77-8f6d-783e-6d27-1848024ce9c8.jpg?imageMogr2/quality/95/thumbnail/!800x400r/gravity/Center/crop/800x400/interlace/1",
                        "App+1 | 喜欢 Pixel 手机的航拍动态壁纸？这款 App 能给你更多「同款」：大都会",
                        "https://cdn.sspai.com/2019/03/07/22e042dd797cd86f72ede915501282cd.jpg?imageMogr2/quality/95/thumbnail/!200x200r/gravity/Center/crop/200x200",
                        "WATERS","03月06日",57,17)
        };
        List<Topic> topicList = Arrays.asList(topics);
        model.addAttribute("topicList",topicList);
        return "recommend";
    }
}
