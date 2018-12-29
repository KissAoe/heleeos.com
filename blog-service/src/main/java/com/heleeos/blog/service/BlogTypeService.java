package com.heleeos.blog.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.heleeos.blog.dao.dto.BlogType;
import com.heleeos.blog.dao.mapper.BlogTypeMapper;

/**
 * 博客分类数据服务层, t_blog_type.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
@Service
public class BlogTypeService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogTypeMapper blogTypeMapper;

    /**
     * 保存博客分类
     * @param blogType 博客分类
     */
    public boolean save(BlogType blogType) {
        if(blogType == null) return false;
        try {
            if(blogType.getId() == null || blogType.getId() == 0) {
                return blogTypeMapper.insert(blogType) == 1;
            } else {
                return blogTypeMapper.update(blogType) == 1;
            }
        } catch (Exception e) {
            logger.error(String.format("保存[博客分类]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 通过ID获取博客分类
     * @param id 分类的ID
     */
    public BlogType get(Integer id) {
        if(id == null || id == 0) return null;
        try {
            BlogType blogType = new BlogType();
            blogType.setId(id);
            return blogTypeMapper.get(blogType);
        } catch (Exception e) {
            logger.error(String.format("获取[博客分类]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }

    /**
     * 获取分类列表
     * @param parentId 父类ID
     */
    public List<BlogType> getList(int parentId) {
        try {
            BlogType blogType = new BlogType();
            blogType.setParentId(parentId);
            return blogTypeMapper.getList(blogType);
        } catch (Exception e) {
            logger.error(String.format("获取[博客分类列表]异常,原因:%s", e.getMessage()), e);
            return null;
        }
    }
}
