package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.NotNullSelector;

import java.lang.annotation.*;

/**
 * 非空校验
 * @author huangfu
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = NotNullSelector.class)
public @interface NotNull {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "此值不能为null";
}
