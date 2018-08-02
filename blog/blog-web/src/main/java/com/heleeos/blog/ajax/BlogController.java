package com.heleeos.blog.ajax;

import com.heleeos.blog.bean.PageInfo;
import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Blog;
import com.heleeos.blog.facede.BlogFacade;
import com.heleeos.blog.request.QueryBlogRequest;
import com.heleeos.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/blog")
public class BlogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogFacade blogFacade;

    @GetMapping(value = "list.json")
    public Result<PageInfo<Blog>> getList(QueryBlogRequest queryBlogListRequest) {
        try {
            PageInfo<Blog> pageInfo = blogFacade.getList(queryBlogListRequest);
            return ResultUtil.SUCCESS(pageInfo);
        } catch (Exception e) {
            logger.error("查询[文章列表]失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }

    /**
     * 根据ID或URL查询文章
     * @param id ID
     * @param url 显示的URL
     */
    @GetMapping(value = "get.json")
    public Result<Blog> getBlog(Integer id, String url) {
        try {
            Blog blog = blogFacade.getBlog(id, url);
            if(blog != null) {
                return ResultUtil.SUCCESS(blog);
            } else {
                return ResultUtil.EMPTY();
            }
        } catch (Exception e) {
            logger.error("查询[文章信息]失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }

    /**
     * 保存文章
     */
    @PostMapping(value = "save")
    public Result<Boolean> saveBlog(@RequestBody Blog blog) {
        try {
            //1. 校验参数
            String errorMessage = blogFacade.checkBlog(blog);
            if(errorMessage != null) {
                return ResultUtil.PARAMETER_ERROR(errorMessage);
            }

            //2. 保存文章
            boolean success = blogFacade.saveBlog(blog);
            if(success) {
                return ResultUtil.SUCCESS();
            } else {
                return ResultUtil.FAILED("保存失败");
            }
        } catch (Exception e) {
            logger.error("保存[文章信息]失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }
}
