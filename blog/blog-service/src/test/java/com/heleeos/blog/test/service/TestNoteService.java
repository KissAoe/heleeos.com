package com.heleeos.blog.test.service;

import com.google.gson.Gson;
import com.heleeos.blog.common.BlogState;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.test.TestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestNoteService extends TestConfig {

    @Autowired
    private BlogService blogService;

    @Test
    public void save() {
        logger.info(blogService.save(blogService.get(1)));
    }

    @Test
    public void getBlog() {
        logger.info(blogService.get(1));
        logger.info(blogService.getByURL("spring-info"));
    }

    @Test
    public void getList() {
        int count = blogService.getCount(null, null, null);
        logger.info("Count:" + count);
        logger.info(new Gson().toJson(blogService.getList(null, null, null, 1, 10)));
    }

    @Test
    public void changeIndex() {
        boolean flag1 = blogService.changeIndex(2, (byte) 0);
        boolean flag2 = blogService.changeState(2, BlogState.RELEASE);
        logger.info("Change index :" + flag1);
        logger.info("Change state :" + flag2);
    }
}
