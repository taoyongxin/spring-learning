package com.soft1851.spring.mybatis.mapper;

import com.soft1851.spring.mybatis.entity.Clazz;
import com.soft1851.spring.mybatis.vo.ClazzVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @author Tao
 */
@Transactional(rollbackFor = Exception.class)
public interface ClazzMapper {
    /**
     * 获取指定班课中所有学生信息
     * @param clazzId
     * @return
     */
    List<ClazzVo> getClazzStudent(int clazzId);

    /**
     * 获取指定班课中所有教师信息
     * @param id
     * @return
     */
    List<Map<String,Object>> getClazzStudent1(int id);

    /**
     * 查询老师所带班级的数据信息
     * @param classId
     * @return
     */
    List<Map<String,Object>> selectLimitFromTeacherInClassByDynamicSql(int classId);

    /**
     * 根据clazzId一对多关联查询本班所有学生
     * @param clazzId
     * @return
     */
    Clazz getClazzOneToMany(int clazzId);

}
