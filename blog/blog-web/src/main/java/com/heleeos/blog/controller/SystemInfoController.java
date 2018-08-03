package com.heleeos.blog.controller;

import com.heleeos.blog.bean.Result;
import com.heleeos.blog.bean.SystemInfo;
import com.heleeos.blog.facede.SystemInfoFacade;
import com.heleeos.blog.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * Created by liyu on 2018/7/27.
 */
@RestController
@RequestMapping("/ajax/system")
public class SystemInfoController {

    @Autowired
    private SystemInfoFacade systemInfoFacade;

    @GetMapping("/getInfo.json")
    public Result<SystemInfo> getSystemInfo() {
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setCpuLoad(systemInfoFacade.getCpuLoad());
        systemInfo.setMemoryUsed(systemInfoFacade.getUsedMemory());
        systemInfo.setJvmInfo(systemInfoFacade.getJVMInfo());
        systemInfo.setMemoryInfo(systemInfoFacade.getMemoryInfo());
        return ResultUtil.SUCCESS(systemInfo);
    }
}
