package com.heleeos.blog.dto;

import com.heleeos.blog.bean.BaseBean;

import java.util.Date;

/**
 * 博客文章, t_blog 表.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
public class Blog extends BaseBean {

    /** ID */
    private Integer id;
    /** 标题 */
    private String blogTitle;
    /** 显示的URL */
    private String displayUrl;
    /** 摘要信息 */
    private String blogSummary;
    /** 创建时间 */
    private Date createTime;
    /** 更新时间 */
    private Date updateTime;
    /** 管理者ID */
    private Integer managerId;
    /** 博客分类 */
    private Integer blogType;
    /** 查看次数 */
    private Integer readCount;
    /** 标签 */
    private String blogTags;
    /** 内容类型 */
    private Byte contentType;
    /** 博客内容 */
    private String blogContent;
    /** 博客状态 */
    private Byte blogState;
    /** 显示顺序 */
    private Byte sortIndex;

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
        this.blogTitle = blogTitle;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getBlogSummary() {
        return blogSummary;
    }

    public void setBlogSummary(String blogSummary) {
        this.blogSummary = blogSummary;
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

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
    }

    public Integer getBlogType() {
        return blogType;
    }

    public void setBlogType(Integer blogType) {
        this.blogType = blogType;
    }

    public Integer getReadCount() {
        return readCount;
    }

    public void setReadCount(Integer readCount) {
        this.readCount = readCount;
    }

    public String getBlogTags() {
        return blogTags;
    }

    public void setBlogTags(String blogTags) {
        this.blogTags = blogTags;
    }

    public Byte getContentType() {
        return contentType;
    }

    public void setContentType(Byte contentType) {
        this.contentType = contentType;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public Byte getBlogState() {
        return blogState;
    }

    public void setBlogState(Byte blogState) {
        this.blogState = blogState;
    }

    public Byte getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Byte sortIndex) {
        this.sortIndex = sortIndex;
    }
}
