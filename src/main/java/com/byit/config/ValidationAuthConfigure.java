package com.byit.config;

import com.byit.aspect.CheckerAspect;
import com.byit.properties.ValidationProperties;
import com.byit.utils.SpringUtil;
import com.byit.validation.Validation;
import com.byit.validation.impl.NotParamValidationImpl;
import com.byit.validation.impl.ParamValidationImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author huangfu
 */
@Configuration
@EnableConfigurationProperties(ValidationProperties.class)
public class ValidationAuthConfigure {

    /**
     * 无注解 @ParamValidation 配置
     * @return 返回NotParamValidationImpl对象
     */
    @Bean
    public Validation getNotParamValidation(){
        return new NotParamValidationImpl();
    }

    /**
     * 有注解 @ParamValidation 配置
     * @return
     */
    @Bean
    public Validation getParamValidation(){
        return new ParamValidationImpl();
    }

    /**
     * 注册切面
     * @return
     */
    @Bean
    public CheckerAspect getCheckerAspect(){
        return new CheckerAspect(getNotParamValidation(),getParamValidation());
    }

    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }
}
