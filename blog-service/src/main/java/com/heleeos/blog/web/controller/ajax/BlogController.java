package com.heleeos.blog.web.controller.ajax;

import com.heleeos.blog.web.bean.PageInfo;
import com.heleeos.blog.web.bean.Result;
import com.heleeos.blog.dao.dto.Blog;
import com.heleeos.blog.web.facede.BlogFacade;
import com.heleeos.blog.web.request.QueryBlogRequest;
import com.heleeos.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 博客文章接口
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/blog")
public class BlogController {

    @Autowired
    private BlogFacade blogFacade;

    @GetMapping(value = "list.json")
    public Result<PageInfo<Blog>> getList(QueryBlogRequest queryBlogListRequest) {
        PageInfo<Blog> pageInfo = blogFacade.getList(queryBlogListRequest);
        return ResultUtil.success(pageInfo);
    }

    /**
     * 根据ID或URL查询文章
     *
     * @param id  ID
     * @param url 显示的URL
     */
    @GetMapping(value = "get.json")
    public Result<Blog> getBlog(Integer id, String url) {
        Blog blog = blogFacade.getBlog(id, url);
        if (blog != null) {
            return ResultUtil.success(blog);
        } else {
            return ResultUtil.empty();
        }
    }

    /**
     * 保存文章
     */
    @PostMapping(value = "save")
    public Result<Integer> saveBlog(@RequestBody Blog blog) {
        //1. 校验参数
        String errorMessage = blogFacade.checkBlog(blog);
        if (errorMessage != null) {
            return ResultUtil.parameterError(errorMessage);
        }

        //2. 保存文章
        boolean success = blogFacade.saveBlog(blog);
        if (success) {
            return ResultUtil.success(blog.getId());
        } else {
            return ResultUtil.failed("保存失败");
        }
    }
}
