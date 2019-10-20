package com.byit.annotation;

import com.byit.selector.interfaces.ValidationSelector;

import java.lang.annotation.*;

/**
 * 元注解 标记此注解为校验选择的注解，同时此注解需要实现自定义的校验类
 * @author huangfu
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE)
public @interface MetaAnnotation {
    /**
     * 定义注解类所指定的实现类
     * @return
     */
    Class<? extends ValidationSelector> validationClass();
}
