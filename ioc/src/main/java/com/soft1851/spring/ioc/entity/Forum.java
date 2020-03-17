package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Forum
 * @Description TODO
 * @date 2020-03-17 13:57
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Forum {
    private Integer forumId;
    private String forumName;
}
