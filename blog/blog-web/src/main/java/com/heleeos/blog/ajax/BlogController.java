package com.heleeos.blog.ajax;

import javax.servlet.http.HttpServletRequest;

import com.heleeos.blog.bean.PageInfo;
import com.heleeos.blog.exception.ServiceException;
import com.heleeos.blog.util.ResultUtil;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.heleeos.blog.dto.Blog;
import com.heleeos.blog.bean.Result;
import com.heleeos.blog.service.BlogService;

/**
 *
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/blog")
@CrossOrigin(origins = "*")
public class BlogController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private BlogService blogService;

    @GetMapping(value = "list.json")
    public Result<PageInfo<Blog>> getList(HttpServletRequest request) {
        try {
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
        } catch (ServiceException e) {
            return ResultUtil.of(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("查询文章列表失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }

    @GetMapping(value = "blog.json")
    public Result<Blog> getBlog(HttpServletRequest request) {
        try {
            String id = request.getParameter("id");
            String url = request.getParameter("url");

            if(id != null) {
                return ResultUtil.SUCCESS(blogService.get(NumberUtils.toInt(id, 0)));
            }

            if(url != null) {
                return ResultUtil.SUCCESS(blogService.getByURL(url));
            }

            return ResultUtil.PARAMETER_ERROR("参数不能为空");
        } catch (ServiceException e) {
            return ResultUtil.of(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("查询文章失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }
}
