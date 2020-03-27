package com.soft1851.spring.web.service.impl;

import com.soft1851.spring.web.dao.TopicDao;
import com.soft1851.spring.web.entity.Topic;
import com.soft1851.spring.web.service.TopicService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Tao
 * @version 1.0
 * @ClassName TopicServiceImpl
 * @Description TODO
 * @date 2020-03-27 10:48
 **/
@Service
@Transactional(rollbackFor = Exception.class)
public class TopicServiceImpl implements TopicService {


    @Resource
    private TopicDao topicDao;

    @Override
    public List<Topic> queryAll() {
        return topicDao.selectAll();
    }

    @Override
    public void addTopic(Topic topic) {
        topicDao.insert(topic);
    }

    @Override
    public int[] batchInsert(List<Topic> topics) {
        return topicDao.batchInsert(topics);
    }
}
