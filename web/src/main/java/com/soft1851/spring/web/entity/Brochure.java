package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Brochure
 * @Description TODO
 * @date 2020-03-27 17:52
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Brochure {
    private Integer id;
    private String title;
    private String desc;
    private String userName;
    private String profile;
    private Double price;
    private Integer lastSectionCount;
    private Integer buyCount;
    private String cover;
    private String avatar;
}
