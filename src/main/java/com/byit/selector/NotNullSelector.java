package com.byit.selector;

import com.byit.adaptation.ValidationAdaptation;
import com.byit.annotation.annotationselector.NotNull;
import com.byit.selector.interfaces.ValidationSelector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 对应注解@NotNull注解
 * 非空校验器
 * @author huangfu
 */
public class NotNullSelector implements ValidationSelector<NotNull> {
    private static final Logger log = LoggerFactory.getLogger(NotBankSelector.class);

    @Override
    public void init(NotNull annotation,Object object) {
        log.info("-------------------NotNull注解参数校验初始化-----------------");
    }

    @Override
    public boolean isValid(NotNull annotation, Object value) {
        log.info("---------------------@NutNull开始校验---------------------------");
        return ValidationAdaptation.dataNotNull(value);
    }

}
