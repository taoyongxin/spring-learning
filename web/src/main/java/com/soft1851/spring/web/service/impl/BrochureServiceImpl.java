package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.BrochureDao;
import com.soft1851.spring.web.entity.Brochure;
import com.soft1851.spring.web.service.BrochureService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName BrochureServiceImpl
 * @Description TODO
 * @date 2020-03-28 11:21
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class BrochureServiceImpl implements BrochureService {
    @Resource
    private BrochureDao brochureDao;
    @Override
    public List<Brochure> queryAll() {
        return brochureDao.selectAll();
    }

    @Override
    public int[] batchInsert(List<Brochure> brochures) {
        return brochureDao.batchInsert(brochures);
    }
}
