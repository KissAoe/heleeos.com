package com.heleeos.blog.ajax;

import javax.servlet.http.HttpServletRequest;

import com.heleeos.blog.bean.PageInfo;
import com.heleeos.blog.common.BlogState;
import com.heleeos.blog.util.ResultUtil;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heleeos.blog.dto.Blog;
import com.heleeos.blog.bean.Result;
import com.heleeos.blog.service.BlogService;
import com.heleeos.blog.service.BlogTypeService;

/**
 *
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogTypeService blogTypeService;

    @GetMapping(value = "list.json")
    public Result<PageInfo<Blog>> getList(HttpServletRequest request) {
        int page = NumberUtils.toInt(request.getParameter("page"), 1);
        int rows = NumberUtils.toInt(request.getParameter("rows"), 5);
        int type = NumberUtils.toInt(request.getParameter("type"), 0);
        byte state = (byte) NumberUtils.toInt(request.getParameter("state"), -1);
        String tags = request.getParameter("tags");

        Byte blogState = state == -1 ? null : state;
        int count = blogService.getCount(type, tags, blogState);
        int max = count / rows + (count % rows == 0 ? 0 : 1);//余数不为0,要加一

        //合法验证
        if(page > max) page = max;
        if(page < 1) page = 1;

        return ResultUtil.SUCCESS(blogService.getList(type, tags, blogState, page, rows));
    }

//    public Re
//
//    @RequestMapping(value = "blog.json")
//    public Result getBlog(HttpServletRequest request) {
//        Result result = new Result();
//
//        String url = request.getParameter("url");
//        if(url != null) {
//            Blog blog = blogService.getByURL(url);
//            result.setCode(200);
//            result.putBeanList(blog);
//        } else {
//            result.setCode(404);
//            result.putInfo("文章未找到");
//        }
//
//        result.putMessage("types", blogTypeService.getList());
//        return result;
//    }
}
