package com.byit.selector;

import com.byit.annotation.annotationselector.NotBank;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

import static com.byit.utils.ValidationAdaptation.dataNotBank;

/**
 * @author huangfu
 */
@Log
public class NotBankSelector implements ValidationSelector<NotBank,Object> {
    @Override
    public void init(NotBank annotation , Object object) {
        log.info("-------------------NotBank注解参数校验初始化-----------------");
    }

    @Override
    public boolean isValid(NotBank annotation, Object value) {
        if(value instanceof String){
            String valueStr = (String)value;
            return dataNotBank(valueStr);
        }
        //不是字符串
        throw new DataValidationException(value+"不是字符串");
    }

}
