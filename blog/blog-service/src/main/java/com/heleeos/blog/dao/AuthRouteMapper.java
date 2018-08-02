package com.heleeos.blog.dao;

import com.heleeos.blog.dto.AuthRoute;

public interface AuthRouteMapper {

    AuthRoute get(Integer id);

    int insert(AuthRoute authRoute);

    int update(AuthRoute authRoute);
}
