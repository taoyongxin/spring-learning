package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Tao
 */
@Transactional(rollbackFor = Exception.class)
public interface StudentMapper {
    /**
     * 新增student，并返回自增主键
     * @param student
     */
    void insert(Student student);

    /**
     * 根据studentId删除Student
     * @param studentId
     */
    void delete(int studentId);

    /**
     * 更新Student
     * @param student
     */
    void update(Student student);

    /**
     * 根据学生id查询学生数据
     * @param id
     * @return
     */
    Student getStudentById(int id);

    /**
     * 批量插入
     * @param students
     * @return
     */
    int batchInsert(@Param("students")List<Student>students);

    /**
     * 批量删除
     * @param idList
     * @return int
     */
    int batchDelete(@Param("idList") List<Integer> idList);

    /**
     * 单表（带两个指定条件）查询
     * @return
     */
    List<Student> selectLimit();

    /**
     * 创建一个学生对象的班级，籍贯，姓名三个中任意，即可过滤查询
     *
     * 单表指定条件查询（结合动态SQL）
     * @param student
     * @return
     */
    List<Student> selectLimitByDynamicSql(Student student);

    /**
     * 查询所有学生，按生日排序，多对一关联学生所在班级信息
     * @return
     */
    List<Student> selectAll();

}
