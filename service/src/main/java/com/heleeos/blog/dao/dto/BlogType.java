package com.heleeos.blog.dao.dto;

import com.heleeos.blog.web.bean.BaseBean;

/**
 * 博客文章的分类, t_blog_type 表.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
public class BlogType extends BaseBean {

    /** 自增ID */
    private Integer id;
    /** 所属模块 */
    private String typeModule;
    /** 分类的名字 */
    private String typeName;
    /** 当前分类的个数 */
    private Integer typeCount;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeModule() {
        return typeModule;
    }

    public void setTypeModule(String typeModule) {
        this.typeModule = typeModule;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeCount() {
        return typeCount;
    }

    public void setTypeCount(Integer typeCount) {
        this.typeCount = typeCount;
    }
}
