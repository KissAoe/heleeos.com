package com.heleeos.blog.web.controller.page;

import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.dao.domain.BlogContent;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.util.ShowdownUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping({"/", "index.html"})
    public ModelAndView index() {
        return blogPage(1);
    }

    @RequestMapping("/page/{page}.html")
    public ModelAndView blogPage(@PathVariable int page) {
        if (page < 0) {
            page = 1;
        }

        long count = blogService.getCount(null, null, null);
        List<Blog> blogList = blogService.getList(null, null, null, page, 5);

        long max = count / 5 + (count % 5 == 0 ? 0 : 1);//余数不为0,要加一

        ModelAndView modelAndView = new ModelAndView("page");
        modelAndView.addObject("blogList", blogList);

        modelAndView.addObject("count", count);
        modelAndView.addObject("page", page);
        modelAndView.addObject("size", 5);
        modelAndView.addObject("max", max);
        return modelAndView;
    }

    @RequestMapping("/blog/{blogUrl}.html")
    public ModelAndView blogInfo(@PathVariable String blogUrl) {
        if (StringUtils.isEmpty(blogUrl)) {
            return new ModelAndView("404");
        }

        Blog blog = blogService.getByURL(blogUrl);
        if (blog == null) {
            return new ModelAndView("404");
        }

        BlogContent blogContent = blogService.getBlogContent(blog.getId());
        if (blogContent == null) {
            return new ModelAndView("404");
        }

        ModelAndView modelAndView = new ModelAndView("blog");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("blogBody", ShowdownUtil.markdownToHtml(blogContent.getBlogContent()));
        return modelAndView;
    }
}
