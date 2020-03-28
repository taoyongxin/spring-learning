package com.soft1851.spring.web.dao;

import com.soft1851.spring.web.entity.Brochure;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName BrochureDao
 * @Description TODO
 * @date 2020-03-28 11:10
 **/
public interface BrochureDao {
    /**
     * 批量新增
     * @param brochures
     * @return
     */
    int[] batchInsert(List<Brochure> brochures);
    /**
     * 查询所有
     * @return List<Brochure>
     */
    List<Brochure> selectAll();
}
