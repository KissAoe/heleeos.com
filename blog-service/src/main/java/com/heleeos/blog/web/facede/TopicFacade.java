package com.heleeos.blog.web.facede;

import com.heleeos.blog.dao.dto.Topic;
import com.heleeos.blog.service.TopicService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 话题相关的操作
 * Created by liyu on 2018/8/3.
 */
@Service
public class TopicFacade {

    @Autowired
    private TopicService topicService;

    /**
     * 获取话题列表
     *
     * @param lastId 上次获取最后一条记录的ID
     * @param count  获取的个数
     */
    public List<Topic> getTopicList(Integer lastId, Integer count) {
        if (lastId == null) lastId = 0;
        if (count == null || count <= 0 || count >= 100) count = 10;
        return topicService.getList(lastId, count);
    }

    /**
     * 检查话题是否正确
     *
     * @param topic 话题
     * @return 错误信息
     */
    public String checkTopic(Topic topic) {
        if (topic == null) {
            return "参数不能为空";
        }

        if (StringUtils.isBlank(topic.getTitle())) {
            return "话题标题不能为空";
        }

        if (StringUtils.isBlank(topic.getContent())) {
            return "话题内容不能为空";
        }

        if (topic.getStatus() == null) {
            topic.setStatus(0);
        }

        return null;
    }

    /**
     * 保存话题
     *
     * @param topic 话题
     */
    public boolean saveTopic(Topic topic) {
        return topicService.save(topic);
    }
}
