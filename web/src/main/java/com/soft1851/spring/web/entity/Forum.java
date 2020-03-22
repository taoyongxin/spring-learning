package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Forum
 * @Description TODO
 * @date 2020-03-20 10:03
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum implements Serializable {
    private Integer forumId;
    private String forumName;
}
