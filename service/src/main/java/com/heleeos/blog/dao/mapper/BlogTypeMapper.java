package com.heleeos.blog.dao.mapper;

import java.util.List;
import com.heleeos.blog.dao.dto.BlogType;
import org.apache.ibatis.annotations.Param;

/**
 * 博客分类表的操作, t_blog_type.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
public interface BlogTypeMapper {

    /**
     * 新增一个文章分类
     * @param blogType 文章分类
     */
    int insert(BlogType blogType);

    /**
     * 更新文章分类
     * @param blogType 文章分类
     */
    int update(BlogType blogType);

    /**
     * 获取文章分类
     * @param blogType 筛选条件
     */
    BlogType get(BlogType blogType);

    /**
     * 获取文章分类列表
     * @param blogType 筛选条件
     */
    List<BlogType> getList(BlogType blogType);
}
