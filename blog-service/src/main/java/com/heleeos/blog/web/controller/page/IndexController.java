package com.heleeos.blog.web.controller.page;

import com.heleeos.blog.dao.domain.Blog;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.util.ShowdownUtil;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.util.StringUtils;
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

    private String body = "### 1. 显示虚拟键盘\n" +
            "a. 点击状态栏的输入法\n" +
            "b. 选择显示虚拟键盘\n" +
            "\n" +
            "图片如下：\n" +
            "![](https://image.heleeos.com/blog/mac-keyboard/key.png)\n" +
            "\n" +
            "### 2. 显示键对应的符号\n" +
            "\n" +
            "可以显示出符号和键盘的对应关系\n" +
            "\n" +
            "|符号|键盘按键|\n" +
            "|:--|:--|\n" +
            "|⇥|tab |\n" +
            "|⇪ |caps lock |\n" +
            "|⌫| delete |\n" +
            "|⇧ | shift| \n" +
            "|⌃  | control | \n" +
            "|⌥ | option |\n" +
            "|⌘ | command |\n" +
            "\n" +
            "图片如下：\n" +
            "![](https://image.heleeos.com/blog/mac-keyboard/1.png)\n" +
            "\n" +
            "### 3. 显示fn按下的符号\n" +
            "\n" +
            "可以看出组合键的对应关系 `fn + `\n" +
            "\n" +
            "|符号|键盘组合按键|说明|\n" +
            "|:--|:--|:--|\n" +
            "|⌦| `fn + delete`|向前删除一个内容|\n" +
            "|↑| `fn + ⬆︎`|page up|\n" +
            "|↓| `fn + ⬇︎`|page down|\n" +
            "|⤒| `fn + ⬅︎`|home|\n" +
            "|⤓| `fn + ➡︎`|end|\n" +
            "\n" +
            "图片如下：\n" +
            "![](https://image.heleeos.com/blog/mac-keyboard/2.png)\n" +
            "\n" +
            "### 4. 显示option按下的符号\n" +
            "\n" +
            "图片如下：\n" +
            "![](https://image.heleeos.com/blog/mac-keyboard/3.png)\n" +
            "\n" +
            "### 5. 显示shift按下的符号\n" +
            "\n" +
            "图片如下：\n" +
            "![](https://image.heleeos.com/blog/mac-keyboard/4.png)\n";

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
        writeStaticFile(modelAndView, "static/page/" + page + ".html");
        return modelAndView;
    }

    @RequestMapping("/blog/{blogUrl}.html")
    public ModelAndView blogInfo(@PathVariable String blogUrl) {
        if (StringUtils.isEmpty(blogUrl)) {
            return new ModelAndView("404");
        }

        Blog blog =  blogService.getByURL(blogUrl);
        if(blog == null) {
            return new ModelAndView("404");
        }


        ModelAndView modelAndView = new ModelAndView("blog");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("blogBody", ShowdownUtil.markdownToHtml(body));
        return modelAndView;
    }

    // todo 修改为拦截器实现
    private void writeStaticFile(ModelAndView modelAndView, String fileName) {
        try {
            File resources = new File(ResourceUtils.getURL("classpath:").getPath());
            File file = new File(resources, fileName);
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
