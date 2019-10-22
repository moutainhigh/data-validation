package com.byit.validation;

import java.lang.annotation.Annotation;

/**
 * 真正的校验实现
 * @author huangfu
 */
public interface Validation {
    /**
     * 这个是不需要验证内部属性是否需要校验，只需要验证其本身是否通过规定校验的
     * @param annotation
     * @param object
     */
    void isValidation(Annotation annotation,Object object);

    /**
     * 这个是需要验证其内部属性是否通过校验的实现类
     * @param object
     */
    void isValidation(Object object);
}
