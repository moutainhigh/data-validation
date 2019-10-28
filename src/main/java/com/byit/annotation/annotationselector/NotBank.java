package com.byit.annotation.annotationselector;

import com.byit.annotation.MetaAnnotation;
import com.byit.selector.NotBankSelector;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@MetaAnnotation(validationClass = NotBankSelector.class)
public @interface NotBank {
    /**
     * 错误信息
     * @return
     */
    String errorMessage() default "{com.byit.annotation.annotationselector.NotBank#errorMessage}";
}
