package com.heleeos.blog.web.controller.page;

import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.service.BlogService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

/**
 * 首页控制器
 * Created by liyu 2019/03/17
 */
@Slf4j
@Controller
@RequestMapping("/")
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private Configuration configuration;

    @RequestMapping({"/", "index.html"})
    public ModelAndView index() {
        return blogPage(1);
    }

    @RequestMapping("/page/{page}.html")
    public ModelAndView blogPage(@PathVariable int page) {
        if(page < 0) {
            page = 1;
        }

        long count = blogService.getCount(null, null, null);
        List<Blog> blogList = blogService.getList(null, null, null, page, 5);

        long max = count / 5 + (count % 5 == 0 ? 0 : 1);//余数不为0,要加一

        ModelAndView modelAndView =  new ModelAndView("page");
        modelAndView.addObject("blogList", blogList);

        modelAndView.addObject("count", count);
        modelAndView.addObject("page", page);
        modelAndView.addObject("size", 5);
        modelAndView.addObject("max", max);
        writeStaticFile(modelAndView, "static/page/" + page + ".html");
        return modelAndView;
    }

    // todo 修改为拦截器实现
    private void writeStaticFile(ModelAndView modelAndView, String fileName) {
        try {
            File resources = new File(ResourceUtils.getURL("classpath:").getPath());
            File file = new File(resources, fileName);
            file.getParentFile().mkdirs();
            log.info("保存静态文件:{}", file.getAbsolutePath());
            try(FileWriter fileWriter = new FileWriter(file)) {
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
