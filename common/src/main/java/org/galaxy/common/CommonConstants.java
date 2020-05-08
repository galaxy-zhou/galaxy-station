package org.galaxy.common;

/**
 * 公共常量类
 */
public interface CommonConstants {

    String PLATFORM_EXCEPTION_MSG = "系统异常，请稍后重试！";

    /**
     * 平台异常类代码
     */
    interface ExceptionCode {
        int PLATFORM_EXCEPTION_CODE = 0;
        int BIZ_EXCEPTION_CODE = 1;
        int PARAM_EXCEPTION_CODE = 2;
    }
}
