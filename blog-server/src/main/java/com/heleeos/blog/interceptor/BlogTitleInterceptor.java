package com.heleeos.blog.interceptor;

import com.heleeos.blog.dao.domain.Blog;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileWriter;
import java.util.Objects;

/**
 *
 * Created by liyu 2019/03/19
 */
@Slf4j
@Component
public class BlogTitleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        if(modelAndView != null && Objects.equals(modelAndView.getViewName(), "blog")) {
            Blog blog = (Blog) modelAndView.getModel().get("blog");
            modelAndView.addObject("title", blog.getBlogTitle());
        }
    }
}
