package com.byit.selector;

import com.byit.annotation.annotationselector.NotNull;
import com.byit.selector.interfaces.ValidationSelector;
import com.byit.utils.ValidationAdaptation;
import lombok.extern.java.Log;

/**
 * 对应注解@NotNull注解
 * 非空校验器
 * @author huangfu
 */
@Log
public class NotNullSelector implements ValidationSelector<NotNull> {
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
