package com.byit.aspect.impl;

import com.byit.annotation.DataValidation;
import com.byit.annotation.MetaAnnotation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 这个是需要验证其内部属性是否通过校验的实现类
 * @author huangfu
 */
public class ParamValidationImpl {



    public void isValidation(Object object){
        try {
            //获取的是方法参数的类的对象
            Class<?> aClass = object.getClass();
            //获取该对象所有的属性
            Field[] declaredFields = aClass.getDeclaredFields();

            //遍历本对象所有的成员变量
            for (int i = 0; i < declaredFields.length; i++) {
                //获取属性上所有的注解
                Annotation[] annotations = declaredFields[i].getAnnotations();
                //如果这个属性没有注解的话就下一个
                if(annotations  ==null || annotations.length<=0){
                    continue;
                }
                /**
                 * 遍历此属性所有的注解，寻找破解法
                 */
                for (int j = 0; j < annotations.length; j++) {
                    //获取这个注解
                    Class<? extends Annotation> selectorClass = annotations[j].annotationType();
                    //判断本注解是否存在元注解MetaAnnotation
                    boolean annotationPresent = selectorClass.isAnnotationPresent(MetaAnnotation.class);
                    //存在就获取内部属性
                    if(annotationPresent){
                        //获取本注解上的错误回调方法  获取错误提示信息
                        Method errorMessage = annotations[j].getClass().getMethod("errorMessage");
                        String errorMessageStr = (String)errorMessage.invoke(annotations[j]);
                        //获取元注解MetaAnnotation
                        MetaAnnotation annotation = selectorClass.getAnnotation(MetaAnnotation.class);
                        //获取注解上的元注解指定的本注解所绑定的实现类
                        Class<? extends ValidationSelector> validationClass = annotation.validationClass();
                        //创建实例
                        ValidationSelector validationSelectorImpl = validationClass.newInstance();

                        //调用校验方法
                        declaredFields[i].setAccessible(true);
                        //调用初始化方法
                        validationSelectorImpl.init(annotations[j],declaredFields[i].get(object));
                        //调用验证器是否验证成功  false失败   true 成功
                        boolean valid = validationSelectorImpl.isValid(annotations[j], declaredFields[i].get(object));
                        if(!valid){
                            throw new DataValidationException(errorMessageStr);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
