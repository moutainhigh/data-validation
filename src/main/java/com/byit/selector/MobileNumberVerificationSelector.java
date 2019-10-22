package com.byit.selector;

import com.byit.annotation.annotationselector.MobileNumberVerification;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

import static com.byit.adaptation.ValidationAdaptation.checkPhone;

/**
 * 手机号校验规则
 * @author huangfu
 */
@Log
public class MobileNumberVerificationSelector implements ValidationSelector<MobileNumberVerification>  {
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
