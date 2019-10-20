package com.byit.selector;

import com.byit.annotation.annotationselector.NotNull;
import com.byit.selector.interfaces.ValidationSelector;
import lombok.extern.java.Log;

/**
 * 对应注解@NotNull注解
 * 非空校验器
 * @author huangfu
 */
@Log
public class NotNullSelector implements ValidationSelector<NotNull,Object> {
    @Override
    public void init(NotNull annotation) {
        log.info("-------------------NotNull注解参数校验初始化-----------------");
    }

    @Override
    public boolean isValid(NotNull annotation, Object value) {
        System.out.println(String.valueOf(value));
        log.info("---------------------@NutNull开始校验---------------------------");
        if(value != null){
            return true;
        }
        return false;
    }

}
