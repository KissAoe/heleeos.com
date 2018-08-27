package com.heleeos.blog.web.facede;

import com.heleeos.blog.web.bean.PageInfo;
import com.heleeos.blog.dao.dto.Blog;
import com.heleeos.blog.web.request.QueryBlogRequest;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.util.NullUtil;
import org.apache.commons.lang.StringUtils;
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
     * 获取文章列表
     *
     * @param queryBlogListRequest 请求
     */
    public PageInfo<Blog> getList(QueryBlogRequest queryBlogListRequest) {
        Integer page = NullUtil.getNotNull(queryBlogListRequest.getPage(), 1);
        Integer rows = NullUtil.getNotNull(queryBlogListRequest.getRows(), 5);
        Integer type = queryBlogListRequest.getType();
        Byte state = queryBlogListRequest.getState();
        String tags = queryBlogListRequest.getTags();

        int count = blogService.getCount(type, tags, state);
        int max = count / rows + (count % rows == 0 ? 0 : 1);//余数不为0,要加一

        //合法验证
        if (rows < 0) rows = 5;
        if (page > max) page = max;
        if (page < 1) page = 1;

        List<Blog> blogList = blogService.getList(type, tags, state, page, rows);

        PageInfo<Blog> pageInfo = new PageInfo<>();
        pageInfo.setPage(page);
        pageInfo.setRows(rows);
        pageInfo.setBeans(blogList);
        pageInfo.setCount(count);
        return pageInfo;
    }

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
     * @param blog 文章
     * @return 错误信息
     */
    public String checkBlog(Blog blog) {
        if(blog == null) {
            return "参数不能为空";
        }

        if(StringUtils.isBlank(blog.getBlogTitle())) {
            return "标题不能为空";
        }

        if(StringUtils.isBlank(blog.getDisplayUrl())) {
            return "显示路径不能为空";
        }

        if(StringUtils.isBlank(blog.getBlogSummary())) {
            return "简介不能为空";
        }

        if(blog.getContentType() == null) {
            return "内容类型不能为空";
        }

        if(blog.getBlogType() == null) {
            return "文章类型不能为空";
        }

        if(StringUtils.isBlank(blog.getBlogContent())) {
            return "文章内容不能为空";
        }

        return null;
    }

    /**
     * 保存文章
     * @param blog 文章
     */
    public boolean saveBlog(Blog blog) {
        return blogService.save(blog);
    }
}
