package com.heleeos.blog.interceptor;

import com.google.gson.Gson;
import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.service.ManagerService;
import com.heleeos.blog.util.CookieUtil;
import com.heleeos.blog.util.ResultUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Created by liyu on 2018/8/2.
 */
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private ManagerService managerService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 检查是否登录
        Result<String> result = ResultUtil.TOKEN_ERROR();
        String token = CookieUtil.getTokenFromCookie(request);
        if(StringUtils.isBlank(token)) {
            writeAjaxResponse(response, result);
            return false;
        }
        Manager manager = managerService.getManager(token);
        if(manager == null) {
            writeAjaxResponse(response, result);
            return false;
        }

        //TODO 登录时间大于4小时


        //TODO 2. 检查是否有权限访问
        request.setAttribute("manager", manager);
        return super.preHandle(request, response, handler);
    }

    /**
     * 写ajax返回结果
     *
     * @param result 要写的内容
     */
    private void writeAjaxResponse(HttpServletResponse response, Result<String> result) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(new Gson().toJson(result));
        } catch (IOException ignored) {}
    }
}
