package com.example.blog.service.impl;

import com.example.blog.bean.Topic;
import com.example.blog.dao.TopicDao;
import com.example.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    public List<Topic> getAllTopics() {
        return topicDao.getAllTopics();
    }

    @Override
    public Topic getTopicById(Integer id) {
        return topicDao.getTopicById(id);
    }

    @Override
    public boolean addTopic(Topic topic) {
        try {
            int maxId = topicDao.getMaxId();
            topic.setId(maxId + 1);
            topicDao.addTopic(topic);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTopic(Integer id) {
        try {
            topicDao.deleteTopic(id);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTopic(Topic topic) {
        try {
            topicDao.updateTopic(topic);
            return true;
        } catch (Exception exception) {
            exception.printStackTrace();
            return false;
        }
    }
}
