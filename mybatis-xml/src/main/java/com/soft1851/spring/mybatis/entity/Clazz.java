package com.soft1851.spring.mybatis.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Clazz
 * @Description TODO
 * @date 2020-03-31 14:15
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Clazz {
    private Integer clazzId;
    private String clazzName;
    private Integer teacherId;

    private Teacher teacher;
    private List<Student> students;
}
