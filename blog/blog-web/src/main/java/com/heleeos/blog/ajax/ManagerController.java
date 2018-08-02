package com.heleeos.blog.ajax;

import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.exception.ServiceException;
import com.heleeos.blog.service.ManagerService;
import com.heleeos.blog.util.ResultUtil;
import com.heleeos.blog.util.TokenUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * Created by liyu on 2018/5/25.
 */
@RestController
@RequestMapping("/ajax/manager")
@CrossOrigin(origins = "*")
public class ManagerController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ManagerService managerService;

    @GetMapping(value = "login.json")
    public Result<Manager> login(HttpServletRequest request) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            if(StringUtils.isBlank(username)) {
                return ResultUtil.PARAMETER_ERROR("用户名不能为空");
            }

            if(StringUtils.isBlank(password)) {
                return ResultUtil.PARAMETER_ERROR("密码不能为空");
            }

            Manager manager = managerService.login(username, password);
            if(manager == null) {
                return ResultUtil.FAILED("用户名或密码错误");
            } else {
                String token = TokenUtil.createToken(manager);
                managerService.updateToken(manager.getId(), token, "");
                return ResultUtil.SUCCESS(manager);
            }
        } catch (ServiceException e) {
            return ResultUtil.of(e.getCode(), e.getMessage());
        } catch (Exception e) {
            logger.error("查询文章失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }
}
