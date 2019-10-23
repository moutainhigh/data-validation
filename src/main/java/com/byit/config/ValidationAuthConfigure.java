package com.byit.config;

import com.byit.properties.ValidationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfu
 */
@Configuration
@EnableConfigurationProperties(ValidationProperties.class)
public class ValidationAuthConfigure {
}
