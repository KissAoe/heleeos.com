package com.heleeos.blog.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heleeos.blog.dto.Blog;
import com.heleeos.blog.dao.BlogMapper;

/**
 * 博客数据服务层, t_blog.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
@Service
public class BlogService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogMapper blogMapper;

    /**
     * 保存文章.
     *
     * @param blog 文章
     */
    public boolean save(Blog blog) {
        if(blog == null) return false;
        try {
            if(blog.getId() == null || blog.getId() == 0) {
                return blogMapper.insert(blog) == 1;
            } else {
                return blogMapper.update(blog) == 1;
            }
        } catch (Exception e) {
            logger.error(String.format("保存[博客文章]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 获取文章.
     *
     * @param id 文章ID
     */
    public Blog get(Integer id) {
        if(id == null || id == 0) return null;
        try {
            Blog blog = new Blog();
            blog.setId(id);
            return blogMapper.get(blog);
        } catch (Exception e) {
            logger.error(String.format("获取[博客文章]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }

    /**
     * 根据URL获取文章.
     *
     * @param url 文章显示的URL.
     */
    public Blog getByURL(String url) {
        if(StringUtils.trimToNull(url) == null) return null;
        try {
            Blog blog = new Blog();
            blog.setDisplayUrl(url);
            return blogMapper.get(blog);
        } catch (Exception e) {
            logger.error(String.format("获取[博客文章(URL)]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }

    /**
     * 查询文章.
     *
     * @param type 分类
     * @param tags 标签
     * @param state 状态
     * @param page 开始位置
     * @param rows 显示条数
     */
    public List<Blog> getList(Integer type, String tags, Byte state, Integer page, Integer rows) {
        int index = (page - 1) * rows;
        if(index < 0) index = 0;
        if(type == null || type == 0) type = null;
        if(StringUtils.trim(tags) == null) tags = null;
        try {
            Blog blog = new Blog();
            blog.setBlogType(type);
            blog.setBlogState(state);
            blog.setBlogTags(tags);
            return blogMapper.getList(blog, index, rows);
        } catch (Exception e) {
            logger.error(String.format("获取[博客文章列表]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }

    /**
     * 获取文章个数.
     *
     * @param type 分类
     * @param tags 标签
     * @param state 状态
     */
    public int getCount(Integer type, String tags, Byte state) {
        if(type == null || type == 0) type = null;
        if(StringUtils.trim(tags) == null) tags = null;
        try {
            Blog blog = new Blog();
            blog.setBlogType(type);
            blog.setBlogState(state);
            blog.setBlogTags(tags);
            return blogMapper.getCount(blog);
        } catch (Exception e) {
            logger.error(String.format("获取[博客文章个数]异常,原因:%s", e.getMessage()), e);
            return 0;
        }
    }

    /**
     * 修改显示顺序.
     *
     * @param id 博客的ID
     * @param newIndex 显示的顺序
     *
     */
    public boolean changeIndex(Integer id, Byte newIndex) {
        try {
            Blog blog = new Blog();
            blog.setId(id);
            blog.setSortIndex(newIndex);
            return blogMapper.update(blog) > 0;
        } catch (Exception e) {
            logger.error(String.format("修改[博客显示顺序]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 修改文章的状态.
     *
     * @param id 文章ID
     */
    public boolean changeState(Integer id, byte newState) {
        if(id == null || id == 0) return false;
        try {
            Blog blog = new Blog();
            blog.setId(id);
            blog.setBlogState(newState);
            return blogMapper.update(blog) > 0;
        } catch (Exception e) {
            logger.error(String.format("删除[博客文章]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 新增阅读次数.
     *
     * @param url 博客的显示URL
     */
    public boolean addCountByUrl(String url) {
        try {
            return blogMapper.addCountByUrl(url) == 1;
        } catch (Exception e) {
            logger.error(String.format("增加[博客阅读次数]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }
}
