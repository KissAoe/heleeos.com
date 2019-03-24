package com.heleeos.blog.web.controller.ajax;

import com.heleeos.blog.web.bean.Result;
import com.heleeos.blog.web.bean.SystemInfo;
import com.heleeos.blog.web.facede.SystemInfoFacade;
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
        systemInfo.setEnv(System.getenv());
        systemInfo.setPropertyNames(System.getProperties().stringPropertyNames());
        return ResultUtil.success(systemInfo);
    }
}
