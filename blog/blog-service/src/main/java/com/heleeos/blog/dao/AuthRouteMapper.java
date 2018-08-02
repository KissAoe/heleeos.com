package com.heleeos.blog.dao;

import com.heleeos.blog.dto.AuthRoute;

public interface AuthRouteMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AuthRoute record);

    int insertSelective(AuthRoute record);

    AuthRoute selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AuthRoute record);

    int updateByPrimaryKey(AuthRoute record);
}