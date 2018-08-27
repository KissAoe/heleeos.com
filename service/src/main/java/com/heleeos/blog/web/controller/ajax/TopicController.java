package com.heleeos.blog.web.controller.ajax;

import com.heleeos.blog.web.bean.Result;
import com.heleeos.blog.dao.dto.Manager;
import com.heleeos.blog.dao.dto.Topic;
import com.heleeos.blog.web.facede.TopicFacade;
import com.heleeos.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 话题相关接口
 * Created by liyu on 2018/8/3.
 */
@RestController
@RequestMapping("/ajax/topic")
public class TopicController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private TopicFacade topicFacade;

    /**
     * 查询话题列表
     */
    @GetMapping(value = "list.json")
    public Result<List<Topic>> getList(Integer lastId, Integer count) {
        return ResultUtil.success(topicFacade.getTopicList(lastId, count));
    }

    /**
     * 保存话题
     */
    @PostMapping(value = "save")
    public Result<Boolean> saveTopic(@RequestBody Topic topic, @RequestAttribute Manager manager) {
        //1. 校验参数
        String errorMessage = topicFacade.checkTopic(topic);
        if (errorMessage != null) {
            return ResultUtil.parameterError(errorMessage);
        }
        topic.setManagerId(manager.getId());

        //2. 保存文章
        boolean success = topicFacade.saveTopic(topic);
        if (success) {
            return ResultUtil.success();
        } else {
            return ResultUtil.failed("保存失败");
        }
    }
}
