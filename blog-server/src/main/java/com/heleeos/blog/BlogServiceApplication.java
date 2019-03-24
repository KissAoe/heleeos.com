package com.heleeos.blog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 应用入口
 * Created by liyu on 2018/8/20.
 */
@SpringBootApplication
@MapperScan("com.heleeos.blog.dao.mapper")
public class BlogServiceApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(BlogServiceApplication.class, args);
    }
}