package com.heleeos.blog.test.service;

import com.google.gson.Gson;
import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.service.ManagerService;
import com.heleeos.blog.test.TestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestManagerService extends TestConfig {

    @Autowired
    private ManagerService managerService;

    @Test
    public void login() {
        Manager manager = managerService.login("admin", "li123456");
        logger.info(new Gson().toJson(manager));
        Result<Manager> managerResult = new Result<>();

        managerResult.setData(manager);
        logger.info(new Gson().toJson(managerResult));
    }
}
