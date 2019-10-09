package com.example.blog.controller;


import com.example.blog.bean.Topic;
import com.example.blog.bean.Value;
import com.example.blog.common.ResultCode;
import com.example.blog.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/all")
    public List<Topic> getAllTopics() {
        return topicService.getAllTopics();
    }

    @GetMapping("/{id}")
    public Topic getTopicById(@PathVariable Integer id) {
        return topicService.getTopicById(id);
    }

    @PostMapping("/add")
    public ResultCode addValue(Topic topic) {
        if (topicService.addTopic(topic)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/delete")
    public ResultCode deleteTopic(Integer id) {
        if (topicService.deleteTopic(id)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/update")
    public ResultCode updateTopic(Topic topic) {
        if (topicService.updateTopic(topic)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }
}
