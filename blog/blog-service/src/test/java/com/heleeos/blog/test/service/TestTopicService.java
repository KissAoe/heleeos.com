package com.heleeos.blog.test.service;

import com.heleeos.blog.dto.Topic;
import com.heleeos.blog.service.TopicService;
import com.heleeos.blog.test.TestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestTopicService extends TestConfig {

    @Autowired
    private TopicService topicService;

    @Test
    public void saveNoteList() {
        for (int i = 1; i <= 100; i++) {
            Topic topic = new Topic();
            topic.setTitle("标题标题");
            topic.setStatus(0);
            topic.setManagerId(0);
            topic.setContent("<p>内容内容</p><hr><p>123123</p>");
            topicService.save(topic);
        }
    }
}
