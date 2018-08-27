package com.heleeos.blog.dao.mapper;

import java.util.List;

import com.heleeos.blog.dao.dto.Blog;
import org.apache.ibatis.annotations.Param;

/**
 * 博客表的操作.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
public interface BlogMapper {

    /**
     * 新增一条文章
     * @param blog 文章
     */
    int insert(Blog blog);

    /**
     * 更新博客内容
     * @param blog 文章
     */
    int update(Blog blog);

    /**
     * 获取文章
     * @param blog 文章查询条件
     */
    Blog get(Blog blog);

    /**
     * 获取文章列表
     * @param blog 文章查询条件
     * @param index 开始位置
     * @param rows 获取个数
     */
    List<Blog> getList(@Param("blog") Blog blog, @Param("index") Integer index, @Param("rows") Integer rows);

    /**
     * 获取文章的个数
     * @param blog 文章查询条件
     */
    int getCount(Blog blog);

    /**
     * 更新文章阅读次数
     * @param url 文章的URL
     */
    int addCountByUrl(String url);
}
