package com.heleeos.blog.dao.domain;

import lombok.Data;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
@Data
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
}