package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
public class Blog {
    /** 自增主键 */
    private Integer id;

    /** 文章标题 */
    private String blogTitle;

    /** 显示的URL */
    private String displayUrl;

    /** 摘要 */
    private String blogSummary;

    /** 所有的标签 */
    private String blogTags;

    /** 类型ID */
    private Integer blogType;

    /** 状态 */
    private Byte blogState;

    /** 发布者ID */
    private Integer managerId;

    /** 阅读次数 */
    private Integer readCount;

    /** 显示顺序 */
    private Byte sortIndex;

    /** 发布时间 */
    private Date createTime;

    /** 最后更新时间 */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl == null ? null : displayUrl.trim();
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary == null ? null : blogSummary.trim();
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags == null ? null : blogTags.trim();
    }

    public Integer getBlogType() {
        return blogType;
    }

    public void setBlogType(Integer blogType) {
        this.blogType = blogType;
    }

    public Byte getBlogState() {
        return blogState;
    }

    public void setBlogState(Byte blogState) {
        this.blogState = blogState;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public Byte getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Byte sortIndex) {
        this.sortIndex = sortIndex;
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
}