package com.heleeos.blog.web.request;

/**
 * 查询文章的参数
 * Created by liyu on 2018/8/2.
 */
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

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
