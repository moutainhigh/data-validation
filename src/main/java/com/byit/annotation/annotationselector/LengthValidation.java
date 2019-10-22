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
    String errorMessage() default "{com.byit.annotation.annotationselector.LengthValidation#errorMessage}";

    /**
     * 定长字符串
     * @return
     */
    int strLength() default -1;

    /**
     * 最小长度
     * @return
     */
    int minLength() default -1;

    /**
     * 最大长度
     * @return
     */
    int maxLength() default -1;
}
