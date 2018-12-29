package com.heleeos.blog.config;

import com.heleeos.blog.interceptor.AuthInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * web相关的配置
 * Created by liyu on 2018/8/26.
 */
@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

    /** 权限过滤器 */
    private final AuthInterceptor authInterceptor;

    private final EnvConfig envConfig;

    @Autowired
    public WebConfig(AuthInterceptor authInterceptor, EnvConfig envConfig) {
        this.authInterceptor = authInterceptor;
        this.envConfig = envConfig;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authInterceptor).addPathPatterns("/ajax/**").excludePathPatterns("/ajax/manager/*");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(envConfig.getCrosOrigin())
                .allowedHeaders("Origin, X-Requested-With, Content-Type, Accept, Authorization")
                .allowedMethods("POST, GET, OPTIONS")
                .allowCredentials(true);
    }
}
