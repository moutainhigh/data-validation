package com.byit.validation.impl;

import com.byit.annotation.MetaAnnotation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import com.byit.validation.AbstractValidation;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * 这个是不需要验证内部属性是否需要校验，只需要验证其本身是否通过规定校验的
 * @author huangfu
 */
@Component
public class NotParamValidationImpl extends AbstractValidation {


    /**
     *校验实现
     * @param annotation  参数上的注解
     * @param value
     */
    @Override
    public void isValidation(Annotation annotation,Object value){
        try{
            //获取此注解上的元注解
            MetaAnnotation metaAnnotation = annotation.annotationType().getAnnotation(MetaAnnotation.class);
            Class<? extends ValidationSelector> validationClass = metaAnnotation.validationClass();

            ValidationSelector validationSelector = validationClass.newInstance();
            validationSelector.init(annotation,value);
            boolean valid = validationSelector.isValid(annotation, value);
            //获取注解上的错误信息
            //获取本注解上的错误回调方法  获取错误提示信息
            Method errorMessage = annotation.getClass().getMethod("errorMessage");
            String errorMessageStr = (String)errorMessage.invoke(annotation);

            if(!valid){
                throw new DataValidationException(errorMessageStr);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
