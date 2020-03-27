package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Topic
 * @Description TODO
 * @date 2020-03-24 17:44
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Topic {
//    private Integer id;
//    private String topicPic;
//    private String topTitle;
//    private String avatar;
//    private String author;
//    private String date;
//    private Integer likes;
//    private Integer comment;

    private String id;
    private String topicName;
    private String topicIcon;
    private String description;
    private Integer msgCount;
    private Integer followersCount;
    private Boolean followed;
}
