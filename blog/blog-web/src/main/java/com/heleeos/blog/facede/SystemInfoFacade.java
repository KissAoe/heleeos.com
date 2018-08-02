package com.heleeos.blog.facede;

import com.heleeos.blog.util.TextFormatUtil;
import com.sun.management.OperatingSystemMXBean;
import org.springframework.stereotype.Service;

import java.lang.management.ManagementFactory;
import java.util.HashMap;
import java.util.Map;

/**
 * 系统信息相关的操作
 * Created by liyu on 2018/7/29.
 */
@Service
public class SystemInfoFacade {

    private OperatingSystemMXBean osBean = ManagementFactory.getPlatformMXBean(OperatingSystemMXBean.class);

    /**
     * 获取cpu使用率
     */
    public double getCpuLoad() {
        return osBean.getSystemCpuLoad() * 100;
    }

    /**
     * 获取内存信息
     */
    public double getUsedMemory() {
        return (osBean.getTotalPhysicalMemorySize() * 1.0 - osBean.getFreePhysicalMemorySize()) / osBean.getTotalPhysicalMemorySize() * 100;
    }


    /**
     * 获取JVM的信息
     */
    public Map<String, Object> getJVMInfo() {
        Map<String, Object> jvmMap = new HashMap<>();

        Runtime runtime = Runtime.getRuntime();
        jvmMap.put("可用内存", TextFormatUtil.formatMemory(runtime.totalMemory()));
        jvmMap.put("剩余内存", TextFormatUtil.formatMemory(runtime.freeMemory()));
        jvmMap.put("最大可用内存", TextFormatUtil.formatMemory(runtime.maxMemory()));

        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        jvmMap.put("虚拟机CPU使用时间", TextFormatUtil.formatTime(operatingSystemMXBean.getProcessCpuTime()));
        jvmMap.put("虚拟机CPU使用率",TextFormatUtil.formatDouble(operatingSystemMXBean.getProcessCpuLoad()));

        return jvmMap;
    }

    /**
     * 获取服务器上的内存信息
     */
    public Map<String, Object> getMemoryInfo() {
        Map<String, Object> systemMap = new HashMap<>();

        OperatingSystemMXBean operatingSystemMXBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        systemMap.put("用于运行的虚拟内存", TextFormatUtil.formatMemory(operatingSystemMXBean.getCommittedVirtualMemorySize()));
        systemMap.put("可用交换空间", TextFormatUtil.formatMemory(operatingSystemMXBean.getFreeSwapSpaceSize()));
        systemMap.put("最大交换空间", TextFormatUtil.formatMemory(operatingSystemMXBean.getTotalSwapSpaceSize()));

        systemMap.put("最大物理内存", TextFormatUtil.formatMemory(operatingSystemMXBean.getTotalPhysicalMemorySize()));
        systemMap.put("可用物理内存", TextFormatUtil.formatMemory(operatingSystemMXBean.getFreePhysicalMemorySize()));

        systemMap.put("CPU使用率", TextFormatUtil.formatDouble(operatingSystemMXBean.getSystemCpuLoad()));
        return systemMap;
    }
}
