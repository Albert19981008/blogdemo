package com.example.blog.service;

import com.example.blog.bean.Topic;

import java.util.List;

public interface TopicService {

    List<Topic> getAllTopics();

    Topic getTopicById(Integer id);

    boolean addTopic(Topic topic);

    boolean deleteTopic(Integer id);

    boolean updateTopic(Topic topic);
}
