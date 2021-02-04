package com.asiainfo.dh.core.exceptions;

import com.asiainfo.dh.core.enums.ResultInfo;

public class BusinessException extends RuntimeException {

    private int code;
    private String msg;

    public BusinessException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BusinessException(ResultInfo resultInfo) {
        code = resultInfo.getCode();
        msg = resultInfo.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
