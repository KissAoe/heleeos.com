package com.heleeos.blog.test.service;

import com.google.gson.Gson;
import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.dao.mapper.BlogMapper;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.test.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by liyu on 2018/12/29.
 */

public class BlogServiceTest extends BaseTest {

    @Autowired
    private BlogService blogService;

    @Test
    public void getList() {
//        blogService.getList();
//        List<Blog> list =  blogMapper.(null, 0, 2);
//        System.out.println(new Gson().toJson(list));
    }

}
