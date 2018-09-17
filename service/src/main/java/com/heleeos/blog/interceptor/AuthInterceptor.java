package com.heleeos.blog.interceptor;

import com.heleeos.blog.config.EnvConfig;
import com.heleeos.blog.dao.dto.Manager;
import com.heleeos.blog.service.ManagerService;
import com.heleeos.blog.util.ResultUtil;
import com.heleeos.blog.web.bean.Result;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 权限拦截器
 * Created by liyu on 2018/8/2.
 */
@Component
public class AuthInterceptor implements HandlerInterceptor {

    /**
     * 管理员服务
     */
    private final ManagerService managerService;

    /**
     * 环境相关配置
     */
    private final EnvConfig envConfig;

    @Autowired
    public AuthInterceptor(ManagerService managerService, EnvConfig envConfig) {
        this.managerService = managerService;
        this.envConfig = envConfig;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //1. 检查是否登录
        if (envConfig.isDebug() && envConfig.isSkipAuth()) {
            return true;
        }

        //2. 获取token
        String token = request.getHeader("Authorization");
        if (StringUtils.isBlank(token)) {
            writeAjaxResponse(response, ResultUtil.tokenError());
            return false;
        }

        //3. 获取管理员
        Manager manager = managerService.getManager(token);
        if (manager == null) {
            writeAjaxResponse(response, ResultUtil.tokenError());
            return false;
        }

        //TODO 登录时间大于4小时


        //TODO 2. 检查是否有权限访问
        request.setAttribute("manager", manager);

        return true;
    }

    /**
     * 写ajax返回结果
     *
     * @param result 要写的内容
     */
    private void writeAjaxResponse(HttpServletResponse response, Result<String> result) {
        try {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(result.toString());
        } catch (IOException ignored) {}
    }
}
