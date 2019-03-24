package com.heleeos.blog.web.facede;

import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.util.NullUtil;
import com.heleeos.blog.web.bean.PageInfo;
import com.heleeos.blog.web.request.QueryBlogRequest;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章相关的操作
 * Created by liyu on 2018/8/2.
 */
@Service
public class BlogFacade {

    @Autowired
    private BlogService blogService;


    /**
     * 获取文章
     *
     * @param id  ID
     * @param url URL
     */
    public Blog getBlog(Integer id, String url) {
        if (id != null) {
            return blogService.get(id);
        }

        if (url != null) {
            return blogService.getByURL(url);
        }

        return null;
    }

    /**
     * 检查文章参数是否正确
     *
     * @param blog 文章
     * @return 错误信息
     */
    public String checkBlog(Blog blog) {
        if (blog == null) {
            return "参数不能为空";
        }

        if (StringUtils.isBlank(blog.getBlogTitle())) {
            return "标题不能为空";
        }

        if (StringUtils.isBlank(blog.getDisplayUrl())) {
            return "显示路径不能为空";
        }

        if (StringUtils.isBlank(blog.getBlogSummary())) {
            return "简介不能为空";
        }

        if (blog.getBlogType() == null) {
            return "文章类型不能为空";
        }

        return null;
    }

    /**
     * 保存文章
     *
     * @param blog 文章
     */
    public boolean saveBlog(Blog blog) {
        return blogService.save(blog);
    }
}
