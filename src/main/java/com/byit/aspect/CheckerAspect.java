package com.byit.aspect;

import com.byit.annotation.MetaAnnotation;
import com.byit.annotation.ParamValidation;
import com.byit.annotation.annotationselector.NotNull;
import com.byit.exception.DataValidationException;
import com.byit.validation.Validation;
import com.byit.validation.impl.NotParamValidationImpl;
import com.byit.validation.impl.ParamValidationImpl;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * @author huangfu
 */
@Component
@Aspect
public class CheckerAspect {
    private static final Logger log = LoggerFactory.getLogger(CheckerAspect.class);

    private final Validation notParamValidation;
    private final Validation paramValidation;

    @Autowired
    public CheckerAspect(NotParamValidationImpl notParamValidation, ParamValidationImpl paramValidation) {
        this.notParamValidation = notParamValidation;
        this.paramValidation = paramValidation;
    }

    @Around("@annotation(com.byit.annotation.DataValidation)")
    public Object dataValidation(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("------------------进入拦截器拦截------------------");
        //获取方法参数
        Object[] args = joinPoint.getArgs();
        //获取方法签名
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        //参数注解，1维是参数，2维是注解
        Annotation[][] annotations = method.getParameterAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            //获取对应的参数
            Object param = args[i];
            //获取参数对应的注解
            Annotation[] paramAnn = annotations[i];

            //注解为空，直接下一个参数
            if(paramAnn.length == 0){
                continue;
            }
            /**
             * 如果参数为null
             * 这里存在三种情况：
             * 1：此参数前存在非空校验注解
             * 2：此参数有注解，但是没有校验注解
             * 3：有校验注解，但是没有非空校验注解直接抛出异常
             */
            if(param == null){
                //是否存在非空注解
                String existNotNullAnnotation = isExistNotNullAnnotation(paramAnn);
                if(existNotNullAnnotation != null){
                    throw new DataValidationException(existNotNullAnnotation);
                }if(notExistValidationAnn(paramAnn)){
                    //还有一种情况 参数有注解，但是不是校验注解
                    continue;
                } else{
                    throw new DataValidationException("---------------第"+i+"个参数为null,无法执行校验规则---------------------");
                }
            }


            /**
             * 获取参数前的注解
             * 此时有两种情况
             * 1：直接校验参数规则
             *      此种规则的判断方式，只需判断参数前的注解是否存在MetaAnnotation自定义元注解即可
             * 2：需要对其内部属性进行校验
             *      此种规则的判断方式，只需要判断前方是否存在ParamValidation注解
             */
            for (Annotation annotation : paramAnn) {
                //这里判断当前注解是否为ParamValidation.class
                boolean isPresenceParamValidationAnnotation = annotation.annotationType().equals(ParamValidation.class);
                if(isPresenceParamValidationAnnotation){
                    //ParamValidationImpl paramValidationImpl = new ParamValidationImpl();
                    paramValidation.isValidation(param);
                    continue;
                }

                //这里判断当前的注解是否可以值接通注解进行校验
                boolean annotationPresent = annotation.annotationType().isAnnotationPresent(MetaAnnotation.class);
                //如果存在
                if(annotationPresent){
                    //NotParamValidationImpl notParamValidation = new NotParamValidationImpl();
                    notParamValidation.isValidation(annotation,param);
                    continue;
                }
            }
        }

        return joinPoint.proceed(args);
    }

    /**
     * 查看是否存在非空校验注解
     * @param annotations
     * @return
     */
    private String isExistNotNullAnnotation(Annotation[] annotations){
        String message = null;
        for (int i = 0; i < annotations.length; i++) {
            //查看是否存在非空校验注解
            boolean flag = annotations[i].annotationType().equals(NotNull.class);

            if (flag){
                //获取注解内部的错误提示信息
                NotNull nulls = (NotNull) annotations[i];
                message = nulls.errorMessage();
            }
        }

        return message;
    }

    /**
     * 查看是否存在校验注解
     * @param annotations
     * @return
     */
    private boolean notExistValidationAnn(Annotation[] annotations){
        //查看是否存在校验注解
        for (int i = 0; i < annotations.length; i++) {
            boolean equals = annotations[i].annotationType().equals(ParamValidation.class);
            boolean annotationPresent = annotations[i].annotationType().isAnnotationPresent(MetaAnnotation.class);
            //存在校验规则
            if(equals || annotationPresent){
                return false;
            }


        }
        return true;
    }
}
