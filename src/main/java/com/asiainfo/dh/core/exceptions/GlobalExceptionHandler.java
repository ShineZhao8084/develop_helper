package com.asiainfo.dh.core.exceptions;

import com.asiainfo.dh.core.enums.ResultInfo;
import com.asiainfo.dh.main.bean.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public APIResponse<?> javaExceptionHandler(Exception ex) {//APIResponse是项目中对外统一的出口封装，可以根据自身项目的需求做相应更改
        logger.error("捕获到Exception异常", ex);
        APIResponse<?> apiResponse = new APIResponse<>();
        if (ex instanceof BusinessException) {
            BusinessException businessException = (BusinessException) ex;
            apiResponse.setCodeAndMsg(businessException.getCode(), businessException.getMsg());
        } else {
            apiResponse.setResultInfo(ResultInfo.UNKNOWNEXCEPTION);
        }
        //异常日志入库

        return apiResponse;
    }

}