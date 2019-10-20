package com.byit.annotation;

import java.lang.annotation.*;

/**
 * 这个注解是一个标记注解，他的作用是为了标记此参数内部有属性是需要进行参数验证的
 * @author huangfu
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
public @interface ParamValidation {
}
