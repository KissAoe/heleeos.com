package com.heleeos.blog.dao.dto;

import com.heleeos.blog.web.bean.BaseBean;

import java.util.Date;

/**
 * 权限路由, t_auth_route 表.
 * Created with Li Yu on 2018/08/01.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
public class AuthRoute extends BaseBean {

    /** 自增ID */
    private Integer id;
    /** 权限名称 */
    private String authName;
    /** 权限路径 */
    private String authPath;
    /** 权限类型, 1-前端、2-后端 */
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
        this.authName = authName;
    }

    public String getAuthPath() {
        return authPath;
    }

    public void setAuthPath(String authPath) {
        this.authPath = authPath;
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
