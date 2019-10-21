package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.MobileNumberVerificationSelector;
import com.byit.selector.NotBankSelector;

import java.lang.annotation.*;

/**
 * 手机号验证注解
 * @author huangfu
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = MobileNumberVerificationSelector.class)
public @interface MobileNumberVerification {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "手机号码不正确";
}
