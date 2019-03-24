package com.heleeos.blog.interceptor;

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

/**
 *
 * Created by liyu 2019/03/19
 */
@Slf4j
@Component
public class StaticFileInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private Configuration configuration;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) {
        String path = request.getServletPath();
        if(path.endsWith(".html")) {
            try {
                File resources = new File(ResourceUtils.getURL("classpath:").getPath());
                File file = new File(resources + "/static", path);
                file.getParentFile().mkdirs();
                log.info("保存静态文件:{}", file.getAbsolutePath());
                try (FileWriter fileWriter = new FileWriter(file)) {
                    Template template = configuration.getTemplate(modelAndView.getViewName() + ".ftl");
                    template.process(modelAndView.getModel(), fileWriter);
                } catch (Exception e) {
                    log.error("保存文件失败", e);
                }
            } catch (Exception e) {
                log.error("获取运行目录失败", e);
            }
        }
    }
}
