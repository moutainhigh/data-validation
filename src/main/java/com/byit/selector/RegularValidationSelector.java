package com.byit.selector;

import com.byit.annotation.annotationselector.RegularValidation;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.regex.Pattern;

/**
 * 正则匹配校验
 * @author huangfu
 */
public class RegularValidationSelector implements ValidationSelector<RegularValidation> {
    private static final Logger log = LoggerFactory.getLogger(NotBankSelector.class);

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
