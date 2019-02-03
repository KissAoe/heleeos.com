package com.heleeos.blog.test.service;

import com.google.gson.Gson;
import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.test.BaseTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liyu on 2018/12/29.
 */
@Slf4j
public class BlogServiceTest extends BaseTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void getList() {
        List<Blog> list = blogService.getList(null, null, null, null, null);
        log.info(new Gson().toJson(list));
    }
}
