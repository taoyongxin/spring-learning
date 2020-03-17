package com.soft1851.spring.ioc.app;

import com.soft1851.spring.ioc.entity.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Tao
 * @version 1.0
 * @ClassName TestStudent
 * @Description TODO
 * @date 2020-03-17 13:00
 **/
public class TestStudent {
    private static Logger logger = LoggerFactory.getLogger(TestStudent.class);

    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
        Student student = (Student) ac.getBean("student");
        logger.info(student.toString());
    }
}
