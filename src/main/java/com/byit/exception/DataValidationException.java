package com.byit.exception;

/**
 * 自定义异常  用于抛出参数校验失败的异常
 * @author huangfu
 */
public class DataValidationException extends RuntimeException {

    public DataValidationException(String message) {
        super(message);
    }

}
