package com.byit.selector.interfaces;


import java.lang.annotation.Annotation;

/**
 * 非空校验选择器接口，所有的校验规则都必须实现此接口
 * @author huangfu
 */
public interface ValidationSelector<T extends Annotation> {
    /**
     * 校验器初始化
     * @param annotation
     */
    void init(T annotation,Object value);

    /**
     * 校验器  返回false则失败   抛出异常打印异常信息
     * 返回true 放行  继续执行下面的方法
     * @param value
     * @param annotation
     * @return
     */
    boolean isValid(T annotation , Object value);


}
