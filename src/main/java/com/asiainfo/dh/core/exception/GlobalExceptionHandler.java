package com.asiainfo.dh.core.exception;

import com.asiainfo.dh.main.bean.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public APIResponse javaExceptionHandler(Exception ex) {//APIResponse是项目中对外统一的出口封装，可以根据自身项目的需求做相应更改
        logger.error("捕获到Exception异常", ex);
        if(ex instanceof MethodArgumentNotValidException){
            MethodArgumentNotValidException exs = (MethodArgumentNotValidException) ex;
            BindingResult bindingResult = exs.getBindingResult();
            if (bindingResult.hasErrors()) {
                StringBuilder sb = new StringBuilder();
                for (ObjectError error : bindingResult.getAllErrors()) {
                    sb.append(error.getDefaultMessage());
                }
                System.out.println(sb.toString());
            }
        } else {
            System.out.println(ex.getMessage());
        }
        //异常日志入库

        return new APIResponse();
    }

}