package com.heleeos.blog.dto;

import com.heleeos.blog.bean.BaseBean;

import java.util.Date;

/**
 * 权限角色, t_auth_role 表.
 * Created with Li Yu on 2018/08/01.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
public class AuthRole extends BaseBean {

    /** 自增ID */
    private Integer id;
    /** 角色名称 */
    private String roleName;
    /** 角色路由 */
    private String roleRoutes;
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

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleRoutes() {
        return roleRoutes;
    }

    public void setRoleRoutes(String roleRoutes) {
        this.roleRoutes = roleRoutes;
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
