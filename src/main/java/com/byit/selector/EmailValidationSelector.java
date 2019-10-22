package com.byit.selector;

import com.byit.annotation.annotationselector.EmailValidation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

import static com.byit.adaptation.ValidationAdaptation.emailValidation;

/**
 * 邮箱格式校验
 * @author huangfu
 */
@Log
public class EmailValidationSelector implements ValidationSelector<EmailValidation> {
    @Override
    public void init(EmailValidation annotation, Object value) {
        log.info("---------------------------@EmailValidation 初始化-------------------------");
    }

    @Override
    public boolean isValid(EmailValidation annotation, Object value) {
        if(value instanceof String){
            return emailValidation((String)value);
        }
        //不是字符串
        throw new DataValidationException(value+"不是字符串");
    }
}
