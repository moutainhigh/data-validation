package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.EmailValidationSelector;
import com.byit.selector.RegularValidationSelector;

import java.lang.annotation.*;

/**
 * 判断是否符合指定的正则表达式
 * @author huangfu
 */
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = RegularValidationSelector.class)
public @interface RegularValidation {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "{com.byit.annotation.annotationselector.RegularValidation#errorMessage}";

    /**
     * 正则表达式
     * @return
     */
    String regularStr();
}
