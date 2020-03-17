package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Post
 * @Description TODO
 * @date 2020-03-17 15:18
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post {
    private Integer postId;
    private Integer forumId;
    private String title;
    private String content;
    private byte[] thumbnail;
    private LocalDateTime postTime;
}
