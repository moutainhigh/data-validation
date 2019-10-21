package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.LengthValidationSelector;

import java.lang.annotation.*;

/**
 * 长度校验
 * @author huangfu
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = LengthValidationSelector.class)
public @interface LengthValidation {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "长度不符合规定值";

    int strLength();
}
