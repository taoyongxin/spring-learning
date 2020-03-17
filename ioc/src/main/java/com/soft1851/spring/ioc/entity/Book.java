package com.soft1851.spring.ioc.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 * @version 1.0
 * @ClassName Book
 * @Description TODO
 * @date 2020-03-17 14:29
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private String name;
    private Double price;
}
