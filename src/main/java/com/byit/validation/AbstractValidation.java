package com.byit.validation;

import java.lang.annotation.Annotation;

/**
 * 适配器
 * @author huangfu
 */
public class AbstractValidation implements Validation {
    @Override
    public void isValidation(Annotation annotation, Object object) {

    }

    @Override
    public void isValidation(Object object) {

    }
}
