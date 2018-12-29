package com.heleeos.blog.web.controller.ajax;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by liyu on 2018/11/16.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @RequestMapping("/")
    public String index() {
        return UUID.randomUUID().toString();
    }

    @RequestMapping("time.json")
    public String time() {
        return LocalDateTime.now().toString();
    }
}
