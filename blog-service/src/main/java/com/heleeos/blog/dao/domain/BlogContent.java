package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/3/18
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent == null ? null : blogContent.trim();
    }
}