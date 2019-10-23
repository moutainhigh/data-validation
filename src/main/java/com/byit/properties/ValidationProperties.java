package com.byit.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 校验配置类
 * @author huangfu
 */

@ConfigurationProperties("byit.validation")
public class ValidationProperties {

    private boolean enabled = false;
    private String url;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ValidationProperties(boolean enabled, String url) {
        this.enabled = enabled;
        this.url = url;
    }

    public ValidationProperties() {
    }
}
