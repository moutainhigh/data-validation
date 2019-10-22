package com.byit.utils;

import com.byit.adaptation.ValidationAdaptation;
import com.byit.validation.Validation;
import com.byit.validation.impl.ParamValidationImpl;
import com.byit.exception.DataValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 规则校验工具类
 * @author huangfu
 */
@Component
public class ValidationUtil {

    private static final String CLASS_NAME = ValidationUtil.class.getName();
    private static Validation paramValidationImpl;

    @Autowired
    public ValidationUtil(ParamValidationImpl paramValidation) {
        ValidationUtil.paramValidationImpl = paramValidation;
    }

    /**
     * 非空校验
     * @param value
     * @param errorMessage
     */
    public static void dataNotNull(Object value,String... errorMessage){
        String message = errorMessageGenerate("dataNotNull", "value is null",errorMessage);
        if(! ValidationAdaptation.dataNotNull(value)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 空串校验
     * @param value
     * @param errorMessage
     */
    public static void dataNotBank(String value,String... errorMessage){
        String message = errorMessageGenerate("dataNotBank", "value is Bank",errorMessage);
        if(! ValidationAdaptation.dataNotBank(value)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 定长字符串校验
     * @param value
     * @param length
     * @param errorMessage
     */
    public static void lengthValidation(String value,int length,String... errorMessage){
        String message = errorMessageGenerate("lengthValidation", "Length of value not equal to Specified length",errorMessage);
        if(! ValidationAdaptation.lengthValidation(value,length)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 字符串最小长度校验器
     * @param value
     * @param minLength
     * @param errorMessage
     */
    public static void  minLengthValidation(String value,int minLength,String... errorMessage){
        String message = errorMessageGenerate("minLengthValidation", "Length of value Less than Specified length",errorMessage);
        if(! ValidationAdaptation.minLengthValidation(value,minLength)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 字符串最大长度校验器
     * @param value
     * @param maxLength
     * @param errorMessage
     */
    public static void maxLengthValidation(String value,int maxLength,String... errorMessage){
        String message = errorMessageGenerate("maxLengthValidation", "Length of value more than the Specified length",errorMessage);
        if(! ValidationAdaptation.maxLengthValidation(value,maxLength)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 中国大陆手机号校验
     * @param phone
     * @param errorMessage
     */
    public static void phoneValidation(String phone,String... errorMessage){
        String message = errorMessageGenerate("phoneValidation", "Not a standard mobile number",errorMessage);
        if(! ValidationAdaptation.checkPhone(phone)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 隐藏中间四位手机号
     * @param phone
     * @param errorMessage
     * @return
     */
    public static String hideMiddleMobile(String phone,String... errorMessage){
        phoneValidation(phone,errorMessage);
        return ValidationAdaptation.hideMiddleMobile(phone);
    }

    /**
     * 邮箱规则校验
     * @param email
     * @param errorMessage
     */
    public static void emailValidation(String email,String... errorMessage){
        String message = errorMessageGenerate("emailValidation", "Email is not a standard mailbox",errorMessage);
        if(! ValidationAdaptation.emailValidation(email)){
            throw new DataValidationException(message);
        }
    }

    /**
     * 实体类校验，校验规则依据实体类内的成员变量注解
     * @param object
     */
    public static void modelIsAnnotationValidation(Object object){
        paramValidationImpl.isValidation(object);
    }

    /**
     * 错误信息生成器
     * @param errorMessage
     * @param methodName
     * @param defaultMessage
     * @return
     */
    private static String errorMessageGenerate(String methodName,String defaultMessage,String... errorMessage){
        if(errorMessage.length > 0){
            return errorMessage[0];
        }
        StringBuilder builder = new StringBuilder(CLASS_NAME);
        builder.append("#").append(methodName).append(":").append(defaultMessage);
        return builder.toString();
    }
}
