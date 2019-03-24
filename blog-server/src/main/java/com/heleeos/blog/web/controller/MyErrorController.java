package com.heleeos.blog.web.controller;

import com.heleeos.blog.util.ResultUtil;
import com.heleeos.blog.web.bean.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.*;

/**
 * 错误相关的
 * Created by liyu on 2018/8/20.
 */
@RestController
@ControllerAdvice
public class MyErrorController implements ErrorController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("error")
    public Result<String> error() {
        return ResultUtil.of(404, "接口不存在");
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Result<String> exception(Exception e) {
        logger.error("出现系统错误", e);
        return ResultUtil.error();
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
