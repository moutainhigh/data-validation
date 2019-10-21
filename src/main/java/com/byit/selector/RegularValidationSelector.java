package com.byit.selector;

import com.byit.annotation.annotationselector.RegularValidation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

import java.util.regex.Pattern;

/**
 * 正则匹配校验
 * @author huangfu
 */
@Log
public class RegularValidationSelector implements ValidationSelector<RegularValidation> {
    @Override
    public void init(RegularValidation annotation, Object value) {
        log.info("--------------------------------@RegularValidationSelector 初始化-----------------------------");
    }

    @Override
    public boolean isValid(RegularValidation annotation, Object value) {
        if(value instanceof String){
            String s = annotation.regularStr();
            String valueStr = (String)value;
            Pattern pattern = Pattern.compile(s);
            return pattern.matcher(valueStr).matches();
        }
        //不是字符串
        throw new DataValidationException(value+"不是字符串");
    }
}
