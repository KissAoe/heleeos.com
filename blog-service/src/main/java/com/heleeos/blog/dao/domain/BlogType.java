package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 *
 * Created by liyu on 
 */
public class BlogType {
    /**  */
    private Integer id;

    /** 父ID */
    private Integer parentId;

    /** 文章类型 */
    private String typeName;

    /** 文章类型的状态 */
    private Byte typeState;

    /** 创建时间 */
    private Date createTime;

    /** 更新时间 */
    private Date updateTime;

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
        this.typeName = typeName == null ? null : typeName.trim();
    }

    public Byte getTypeState() {
        return typeState;
    }

    public void setTypeState(Byte typeState) {
        this.typeState = typeState;
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