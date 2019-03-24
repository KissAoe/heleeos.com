package com.heleeos.blog.config;

import com.heleeos.blog.interceptor.BlogTitleInterceptor;
import com.heleeos.blog.interceptor.StaticFileInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * xx
 * Created by liyu 2019/03/19
 */
@Component
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private StaticFileInterceptor staticFileInterceptor;

    @Autowired
    private BlogTitleInterceptor blogTitleInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(staticFileInterceptor);
        registry.addInterceptor(blogTitleInterceptor);
    }
}
