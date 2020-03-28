package com.soft1851.spring.web.service;

import com.soft1851.spring.web.entity.Brochure;

import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName BrochureService
 * @Description TODO
 * @date 2020-03-28 11:20
 **/
public interface BrochureService {
    /**
     *查询所有
     * @return
     */
    List<Brochure> queryAll();

    /**
     * 批量新增
     * @param brochures
     * @return
     */
    int[] batchInsert(List<Brochure> brochures);
}
