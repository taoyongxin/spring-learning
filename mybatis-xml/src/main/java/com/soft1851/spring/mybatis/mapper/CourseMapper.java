package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Course;

/**
 * @author Tao
 */
public interface CourseMapper {
    /**
     *在CourseMapper.java接口中加入按班课id查询班课的方法，
     * 可以在查询到符合条件的班课数据的同时，将选修这门课程的学生数据也查到（也可以自己再加条件过滤）。
     * @param courseId
     * @return
     */
    Course getCourseById(int courseId);
}
