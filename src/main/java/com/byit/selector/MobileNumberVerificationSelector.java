package com.byit.selector;

import com.byit.annotation.annotationselector.MobileNumberVerification;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.byit.adaptation.ValidationAdaptation.checkPhone;

/**
 * 手机号校验规则
 * @author huangfu
 */
public class MobileNumberVerificationSelector implements ValidationSelector<MobileNumberVerification>  {
    private static final Logger log = LoggerFactory.getLogger(MobileNumberVerificationSelector.class);
    @Override
    public void init(MobileNumberVerification annotation, Object value) {
        log.info("--------------------------@MobileNumberVerification进入初始化操作------------------------------");
    }

    @Override
    public boolean isValid(MobileNumberVerification annotation, Object value) {
        if(value instanceof String){
            String valueStr = (String)value;
            return checkPhone(valueStr);
        }
        //不是字符串
        throw new DataValidationException(value+"不是字符串");
    }
}
