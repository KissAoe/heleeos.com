package com.heleeos.blog.service;

import com.heleeos.blog.dao.mapper.TopicMapper;
import com.heleeos.blog.dao.dto.Topic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 话题数据服务层, t_topic.
 * Created with Li Yu on 2018/08/01.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.0
 */
@Service
public class TopicService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TopicMapper topicMapper;

    /**
     * 保存话题.
     *
     * @param topic 话题
     */
    public boolean save(Topic topic) {
        if(topic == null) return false;
        try {
            if(topic.getId() == null || topic.getId() == 0) {
                return topicMapper.insert(topic) == 1;
            } else {
                return topicMapper.update(topic) == 1;
            }
        } catch (Exception e) {
            logger.error(String.format("保存[话题]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 查询话题列表.
     *
     * @param lastId 最近一条的ID
     * @param rows 显示条数
     */
    public List<Topic> getList(Integer lastId, Integer rows) {
        if(lastId == null) lastId = 0;
        if(rows == null) rows = 10;
        try {
            return topicMapper.getList(lastId, rows);
        } catch (Exception e) {
            logger.error(String.format("查询[话题]列表异常,原因:%s", e.getMessage()), e);
            return new LinkedList<>();
        }
    }
}
