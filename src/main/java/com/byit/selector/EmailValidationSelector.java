package com.byit.selector;

import com.byit.annotation.annotationselector.EmailValidation;
import com.byit.exception.DataValidationException;
import com.byit.properties.ValidationProperties;
import com.byit.selector.interfaces.ValidationSelector;
import com.byit.utils.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import static com.byit.adaptation.ValidationAdaptation.emailValidation;

/**
 * 邮箱格式校验
 * @author huangfu
 */
public class EmailValidationSelector implements ValidationSelector<EmailValidation> {
    private static final Logger log = LoggerFactory.getLogger(EmailValidationSelector.class);
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
