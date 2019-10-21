package com.byit.selector;

import com.byit.annotation.annotationselector.LengthValidation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

import static com.byit.utils.ValidationAdaptation.lengthValidation;

/**
 * 长度校验
 * @author huangfu
 */
@Log
public class LengthValidationSelector implements ValidationSelector<LengthValidation> {

    @Override
    public void init(LengthValidation annotation, Object value) {
        log.info("---------------------------@LengthValidation初始化----------------------");
    }

    @Override
    public boolean isValid(LengthValidation annotation, Object value) {
        int i = annotation.strLength();
        if(value instanceof String){
            String valueStr = (String)value;
            return lengthValidation(valueStr,i);
        }
        //不是字符串
        throw new DataValidationException(value+"不是字符串");
    }
}
