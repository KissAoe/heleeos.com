package com.heleeos.blog.web.bean;

import lombok.Data;

import java.util.Map;
import java.util.Set;

/**
 * 系统信息
 * Created by liyu on 17/12/2017.
 */
@Data
public class SystemInfo {

    /** 服务器相关信息 */
    private Map<String, Object> serverInfo;

    /** jvm信息 */
    private Map<String, Object> jvmInfo;

    /** 内存信息 */
    private Map<String, Object> memoryInfo;

    /** cpu使用率 */
    private double cpuLoad;

    /** 内存使用率 */
    private double memoryUsed;

    private Map<String, String> env;

    private Set<String> propertyNames;
}
