package com.heleeos.blog.web.facede;

import com.heleeos.blog.dao.dto.Blog;
import com.heleeos.blog.dao.dto.BlogType;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.service.BlogTypeService;
import com.heleeos.blog.util.NullUtil;
import com.heleeos.blog.web.bean.PageInfo;
import com.heleeos.blog.web.request.QueryBlogRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章相关的操作
 * Created by liyu on 2018/8/2.
 */
@Service
public class BlogTypeFacade {

    @Autowired
    private BlogTypeService blogTypeService;

    /**
     * 获取文章列表
     *
     */
    public List<BlogType> getList(Integer parentId) {
        if(parentId == null) {
            parentId = 0;
        }
        return blogTypeService.getList(parentId);
    }
}
