package com.heleeos.blog.web.controller.ajax;

import com.heleeos.blog.dao.dto.BlogType;
import com.heleeos.blog.util.ResultUtil;
import com.heleeos.blog.web.bean.Result;
import com.heleeos.blog.web.facede.BlogTypeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 博客文章接口
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/blog/type")
public class BlogTypeController {

    @Autowired
    private BlogTypeFacade blogTypeFacade;

    @GetMapping(value = "list.json")
    public Result<List<BlogType>> getList(Integer parentId) {
        List<BlogType> blogTypeList = blogTypeFacade.getList(parentId);
        return ResultUtil.success(blogTypeList);
    }
}
