package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName CourseStudent
 * @Description TODO
 * @date 2020-03-31 14:19
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseStudent {
    private Integer id;
    private Integer courseId;
    private Integer studentId;
}
