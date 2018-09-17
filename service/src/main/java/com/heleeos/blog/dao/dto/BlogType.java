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
    /** 父类ID */
    private Integer parentId;
    /** 分类的名字 */
    private String typeName;
    /** 当前分类的个数 */
    private Integer typeState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getTypeState() {
        return typeState;
    }

    public void setTypeState(Integer typeState) {
        this.typeState = typeState;
    }
}
