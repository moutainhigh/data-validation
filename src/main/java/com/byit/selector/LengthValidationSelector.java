package com.byit.selector;

import com.byit.annotation.annotationselector.LengthValidation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import com.byit.adaptation.ValidationAdaptation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 长度校验
 *
 * @author huangfu
 */
public class LengthValidationSelector implements ValidationSelector<LengthValidation> {
    private static final Logger log = LoggerFactory.getLogger(LengthValidationSelector.class);
    @Override
    public void init(LengthValidation annotation, Object value) {
        log.info("---------------------------@LengthValidation初始化----------------------");
    }

    @Override
    public boolean isValid(LengthValidation annotation, Object value) {
        if (!(value instanceof String)) {
            //不是字符串
            throw new DataValidationException(value + "不是字符串");
        }
        int length = annotation.strLength();
        int minLength = annotation.minLength();
        int maxLength = annotation.maxLength();

        String valueStr = (String) value;
        if (length >= 0) {
            return ValidationAdaptation.lengthValidation(valueStr, length);
        } else if (minLength >= 0 && maxLength >= 0) {
            return ValidationAdaptation.intervalLengthValidation(valueStr,minLength,maxLength);
        } else if (minLength >= 0) {
            return ValidationAdaptation.minLengthValidation(valueStr,minLength);
        } else if (maxLength >= 0) {
            return ValidationAdaptation.maxLengthValidation(valueStr,maxLength);
        }
        return true;
    }
}
