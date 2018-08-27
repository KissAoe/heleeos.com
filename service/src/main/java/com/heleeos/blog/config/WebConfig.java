package com.heleeos.blog.config;

import com.heleeos.blog.interceptor.AuthInterceptor;
import com.heleeos.blog.interceptor.CrossDomainInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web相关的配置
 * Created by liyu on 2018/8/26.
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    /** 权限过滤器 */
    private final AuthInterceptor authInterceptor;

    /** 跨域过滤器 */
    private final CrossDomainInterceptor crossDomainInterceptor;

    @Autowired
    public WebConfig(AuthInterceptor authInterceptor, CrossDomainInterceptor crossDomainInterceptor) {
        this.authInterceptor = authInterceptor;
        this.crossDomainInterceptor = crossDomainInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/ajax/**").excludePathPatterns("/ajax/manager/*");
        registry.addInterceptor(crossDomainInterceptor).addPathPatterns("/ajax/**");
    }
}
