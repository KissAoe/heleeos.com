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

    private boolean debug;

    private boolean skipAuth;

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
}
