package com.byit.annotation;

import java.lang.annotation.*;

/**
 * 他是一个标记注解，仅用于拦截器拦截使用
 * 注解范围是方法上
 * 定义在方法上，证明此方法需要被拦截器拦截，需要其中参数被校验
 * @author huangfu
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DataValidation {}
