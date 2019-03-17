package com.heleeos.blog.dao.domain;

import lombok.Data;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
@Data
public class BlogContent {
    /** 自增ID */
    private Integer id;

    /** 文章ID */
    private Integer blogId;

    /** 文章标题 */
    private String blogTitle;

    /** 发布时间 */
    private Date createTime;

    /** 最后更新时间 */
    private Date updateTime;

    /** 文章内容 */
    private String blogContent;
}