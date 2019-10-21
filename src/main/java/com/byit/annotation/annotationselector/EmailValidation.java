package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.EmailValidationSelector;
import com.byit.selector.LengthValidationSelector;

import java.lang.annotation.*;

/**
 * 邮箱验证
 * @author huangfu
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = EmailValidationSelector.class)
public @interface EmailValidation {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "邮箱格式不正确";
}
