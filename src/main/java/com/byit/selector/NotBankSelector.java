package com.byit.selector;

import com.byit.annotation.annotationselector.NotBank;
import com.byit.exception.DataValidationException;
import com.byit.selector.interfaces.ValidationSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.byit.adaptation.ValidationAdaptation.dataNotBank;

/**
 * @author huangfu
 */
public class NotBankSelector implements ValidationSelector<NotBank> {
    private static final Logger log = LoggerFactory.getLogger(NotBankSelector.class);

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
