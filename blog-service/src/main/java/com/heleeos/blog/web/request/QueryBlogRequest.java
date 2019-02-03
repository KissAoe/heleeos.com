package com.heleeos.blog.web.request;

import lombok.Data;

/**
 * 查询文章的参数
 * Created by liyu on 2018/8/2.
 */
@Data
public class QueryBlogRequest {

    /**
     * 当前的页码
     */
    private Integer page;

    /**
     * 查询行数
     */
    private Integer rows;

    /**
     * 查询文章类型
     */
    private Integer type;

    /**
     * 查询文章状态
     */
    private Byte state;

    /**
     * 查询文章标签
     */
    private String tags;
}
