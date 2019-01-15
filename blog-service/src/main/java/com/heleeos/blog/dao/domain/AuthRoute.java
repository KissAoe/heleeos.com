package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 *
 * Created by liyu on 
 */
public class AuthRoute {
    /** 自增ID */
    private Integer id;

    /** 规则名称 */
    private String authName;

    /** 请求的路径，前端地址或后端接口 */
    private String authPath;

    /** 前端还是后端, 1 - 前端, 2 - 后端 */
    private Integer authType;

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

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName == null ? null : authName.trim();
    }

    public String getAuthPath() {
        return authPath;
    }

    public void setAuthPath(String authPath) {
        this.authPath = authPath == null ? null : authPath.trim();
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
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