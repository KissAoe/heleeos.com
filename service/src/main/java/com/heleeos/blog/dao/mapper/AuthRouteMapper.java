package com.heleeos.blog.dao.mapper;

import com.heleeos.blog.dao.dto.AuthRoute;

public interface AuthRouteMapper {

    AuthRoute get(Integer id);

    int insert(AuthRoute authRoute);

    int update(AuthRoute authRoute);
}
