package com.heleeos.blog.interceptor;

import com.heleeos.blog.config.EnvConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跨域过滤器
 * Created by liyu on 2018/5/7.
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CrossDomainInterceptor implements Filter {

    @Autowired
    private EnvConfig envConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        addAccessControl((HttpServletResponse) response);

        if(((HttpServletRequest) request).getMethod().equalsIgnoreCase("OPTIONS")) {
            return;
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {}

    /**
     * 添加跨域请求
     */
    private void addAccessControl(HttpServletResponse response) {
        response.setHeader("Access-Control-Allow-Origin", envConfig.getCrosOrigin());
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization");
        response.setHeader("Access-Control-Allow-Credentials", "true");
    }
}
