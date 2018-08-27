package com.heleeos.blog.web.request;

/**
 *
 * Created by liyu on 2018/8/2.
 */
public class QueryBlogRequest {

    private Integer page;

    private Integer rows;

    private  Integer type;

    private Byte state;

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
