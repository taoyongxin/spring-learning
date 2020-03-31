package com.soft1851.spring.mybatis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName MatterDto
 * @Description TODO
 * @date 2020-03-31 17:12
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatterDto {
    private String teacherName;
    private String clazzName;
    private String studentName;
}
