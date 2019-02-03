package com.heleeos.blog.dao.domain;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
public class AuthRole {
    /**  */
    private Integer id;

    /**  */
    private String roleName;

    /**  */
    private String roleRoutes;

    /**  */
    private Date createTime;

    /**  */
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleRoutes() {
        return roleRoutes;
    }

    public void setRoleRoutes(String roleRoutes) {
        this.roleRoutes = roleRoutes == null ? null : roleRoutes.trim();
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