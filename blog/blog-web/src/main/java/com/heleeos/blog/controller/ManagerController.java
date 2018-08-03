package com.heleeos.blog.controller;

import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.service.ManagerService;
import com.heleeos.blog.util.CookieUtil;
import com.heleeos.blog.util.ResultUtil;
import com.heleeos.blog.util.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/manager")
public class ManagerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "login.json")
    public Result<Manager> login(String userName, String passWord, HttpServletResponse response) {
        try {
            if(StringUtils.isBlank(userName)) {
                return ResultUtil.PARAMETER_ERROR("用户名不能为空");
            }

            if(StringUtils.isBlank(passWord)) {
                return ResultUtil.PARAMETER_ERROR("密码不能为空");
            }

            Manager manager = managerService.login(userName, passWord);
            if(manager == null) {
                return ResultUtil.FAILED("用户名或密码错误");
            } else {
                String newToken = TokenUtil.createToken(manager);
//                CookieUtil.saveTokenToCookie(response, newToken);
                manager.setLoginToken(newToken);
                managerService.updateToken(manager.getId(), newToken, "");
                return ResultUtil.SUCCESS(manager);
            }
        } catch (Exception e) {
            logger.error("查询文章失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }

    @GetMapping(value = "logout.json")
    public Result<String> logout(HttpServletResponse response) {
        CookieUtil.removeCookieToken(response);
        return ResultUtil.SUCCESS("退出成功");
    }
}
