package org.galaxy.common.exception;

/**
 * 平台业务异常类
 */
public class BizException extends RuntimeException{

    public BizException(String message){
        super(message);
    }
}
