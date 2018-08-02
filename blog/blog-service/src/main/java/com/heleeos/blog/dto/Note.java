package com.heleeos.blog.dto;

import java.util.Date;

/**
 * 每日记录
 * Created by liyu on 2018/7/27.
 */
public class Note {

    /** 自增ID */
    private Integer id;
    /** 状态 */
    private Integer status;
    /** 内容 */
    private String content;
    /** 管理员ID */
    private Integer managerId;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public void setManagerId(Integer managerId) {
        this.managerId = managerId;
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
