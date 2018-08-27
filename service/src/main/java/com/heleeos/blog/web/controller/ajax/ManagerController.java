package com.heleeos.blog.web.controller.ajax;

import com.heleeos.blog.web.bean.Result;
import com.heleeos.blog.dao.dto.Manager;
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
 * 管理员相关接口
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/manager")
public class ManagerController {

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "login.json")
    public Result<Manager> login(String userName, String passWord, HttpServletResponse response) {

        if (StringUtils.isBlank(userName)) {
            return ResultUtil.parameterError("用户名不能为空");
        }

        if (StringUtils.isBlank(passWord)) {
            return ResultUtil.parameterError("密码不能为空");
        }

        Manager manager = managerService.login(userName, passWord);
        if (manager == null) {
            return ResultUtil.failed("用户名或密码错误");
        } else {
            String newToken = TokenUtil.createToken(manager);
//                CookieUtil.saveTokenToCookie(response, newToken);
            manager.setLoginToken(newToken);
            managerService.updateToken(manager.getId(), newToken, "");
            return ResultUtil.success(manager);
        }
    }

    @GetMapping(value = "logout.json")
    public Result<String> logout(HttpServletResponse response) {
        CookieUtil.removeCookieToken(response);
        return ResultUtil.success("退出成功");
    }
}
