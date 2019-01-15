package com.heleeos.blog.web.bean;

import java.util.Map;

/**
 * 系统信息
 * Created by liyu on 17/12/2017.
 */
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

    public Map<String, Object> getServerInfo() {
        return serverInfo;
    }

    public void setServerInfo(Map<String, Object> serverInfo) {
        this.serverInfo = serverInfo;
    }

    public Map<String, Object> getJvmInfo() {
        return jvmInfo;
    }

    public void setJvmInfo(Map<String, Object> jvmInfo) {
        this.jvmInfo = jvmInfo;
    }

    public Map<String, Object> getMemoryInfo() {
        return memoryInfo;
    }

    public void setMemoryInfo(Map<String, Object> memoryInfo) {
        this.memoryInfo = memoryInfo;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(double cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public double getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(double memoryUsed) {
        this.memoryUsed = memoryUsed;
    }
}
