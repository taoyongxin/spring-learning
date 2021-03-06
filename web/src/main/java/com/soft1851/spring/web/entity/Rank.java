package com.soft1851.spring.web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Tao
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Rank {
   private Integer id;
   private String pic;
   private String title;
   private String author;
   private String duration;
}
