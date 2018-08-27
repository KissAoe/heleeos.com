package com.heleeos.blog.dao.mapper;

import com.heleeos.blog.dao.dto.AuthRole;

public interface AuthRoleMapper {

    /**
     * 获取授权角色
     * @param id ID
     */
    AuthRole get(Integer id);

    /**
     * 新增授权角色
     * @param authRole 角色
     */
    int insert(AuthRole authRole);

    /**
     * 更新授权角色
     * @param authRole 角色
     */
    int update(AuthRole authRole);
}
