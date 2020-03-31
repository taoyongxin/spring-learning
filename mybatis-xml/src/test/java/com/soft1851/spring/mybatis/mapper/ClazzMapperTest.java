package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.dto.MatterDto;
import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.entity.Student;
import com.soft1851.spring.mybatis.vo.ClazzVo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring-mybatis.xml"})
public class ClazzMapperTest {
    @Resource
    private ClazzMapper clazzMapper;

    @Test
    public void getClazzStudent() {
        List<ClazzVo> clazzVo = clazzMapper.getClazzStudent(1);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void getClazzStudent1() {
        List<Map<String,Object>> clazzVo = clazzMapper.getClazzStudent1(2);
        clazzVo.forEach(System.out::println);
    }

    @Test
    public void selectLimitFromTeacherInClassByDynamicSql() {
        MatterDto matterDto = MatterDto.builder()
                .teacherName("许老师")
                .clazzName("软件1851")
                .studentName("王锋")
                .build();
    }


    @Test
    public void getClazzOneToMany() {
        Clazz clazz = clazzMapper.getClazzOneToMany(1);
        System.out.println(clazz.getClazzId()+","+clazz.getClazzName());
        List<Student> students = clazz.getStudents();
        students.forEach(student -> {
            System.out.println(student.getStudentId()+
                    ","+student.getStudentName() +
                    ","+student.getHometown()+
                    ","+student.getBirthday());
        });
    }


}