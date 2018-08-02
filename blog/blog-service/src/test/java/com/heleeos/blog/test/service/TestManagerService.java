package com.heleeos.blog.test.service;

import com.heleeos.blog.test.TestConfig;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import com.heleeos.blog.service.ManagerService;

public class TestManagerService extends TestConfig {

    private Logger logger = Logger.getLogger(getClass());

    @Autowired
    private ManagerService managerService;

    @Test
    public void login() {
        try {
            toLogger(logger, managerService.login("admin", DigestUtils.md5DigestAsHex("li123456".getBytes())));
        } catch (Exception e) {
            logger.error("登录失败", e);
        }
    }
}
