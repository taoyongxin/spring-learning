package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName HotList
 * @Description TODO
 * @date 2020-03-27 22:33
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HotList {
    private Integer id;
    private String title;
    private String releaseTime;
    private String visits;
    private String brief;
    private String picture;
}
