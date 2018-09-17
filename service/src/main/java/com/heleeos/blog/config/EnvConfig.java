package com.heleeos.blog.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 环境配置
 * Created by liyu on 2018/8/26.
 */
@Component
@ConfigurationProperties(prefix = "env")
public class EnvConfig {

    /** 是否开启debug模式 */
    private boolean debug;

    /** 是否跳过授权验证 */
    private boolean skipAuth;

    /** 跨域的请求源 */
    private String crosOrigin;

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isSkipAuth() {
        return skipAuth;
    }

    public void setSkipAuth(boolean skipAuth) {
        this.skipAuth = skipAuth;
    }

    public String getCrosOrigin() {
        return crosOrigin;
    }

    public void setCrosOrigin(String crosOrigin) {
        this.crosOrigin = crosOrigin;
    }
}
