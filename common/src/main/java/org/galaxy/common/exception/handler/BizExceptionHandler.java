package org.galaxy.common.exception.handler;

import com.alibaba.fastjson.JSONObject;
import org.galaxy.common.CommonConstants;
import org.galaxy.common.exception.BizException;
import org.galaxy.common.exception.ParamException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 平台公共异常处理
 */

@ControllerAdvice
public class BizExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(BizExceptionHandler.class);

    @Autowired
    private MessageSource messageSource;

    /**
     * 处理ParameterException自定义异常
     * @param exception
     * @return
     */
    @ExceptionHandler(ParamException.class)
    @ResponseBody
    public String handleParameterException(ParamException exception){
        return exceptionResponse(exception.getMessage(), CommonConstants.ExceptionCode.PARAM_EXCEPTION_CODE);
    }

    /**
     * 处理BizException自定义异常
     * @param exception
     * @return
     */
    @ExceptionHandler(BizException.class)
    @ResponseBody
    public String handleBizException(BizException exception){
        return exceptionResponse(exception.getMessage(),CommonConstants.ExceptionCode.BIZ_EXCEPTION_CODE);
    }

    /**
     * 处理全部异常
     * @param throwable
     * @return
     */
    @ExceptionHandler({Throwable.class})
    @ResponseBody
    public String handleAllException(Throwable throwable){
        return exceptionResponse(CommonConstants.PLATFORM_EXCEPTION_MSG,CommonConstants.ExceptionCode.PLATFORM_EXCEPTION_CODE);
    }


    /**
     * 组装异常信息的返回结果信息
     *
     * @param message  异常信息
     * @param errorCode 错误码
     * @return
     */
    private String exceptionResponse(String message,int errorCode){
        logger.error(errorCode+"-----"+message);
        JSONObject data = new JSONObject();
        data.put("message",message);
        data.put("code",errorCode );
        return data.toJSONString();
    }
}