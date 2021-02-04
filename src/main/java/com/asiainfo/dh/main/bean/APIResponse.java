package com.asiainfo.dh.main.bean;

import com.asiainfo.dh.core.enums.ResultInfo;

import java.io.Serializable;

public class APIResponse<E> implements Serializable{

    private int code;
    private String msg;
    private E result;

    public APIResponse() {
    }

    public APIResponse(int code, String msg, E result) {
        this.code = code;
        this.msg = msg;
        this.result = result;
    }

    public APIResponse(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.msg = resultInfo.getMsg();
    }

    public APIResponse(ResultInfo resultInfo, E result) {
        this.code = resultInfo.getCode();
        this.msg = resultInfo.getMsg();
        this.result = result;
    }

    public void setResultInfo(ResultInfo resultInfo) {
        this.code = resultInfo.getCode();
        this.msg = resultInfo.getMsg();
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

    public void setCodeAndMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public E getResult() {
        return result;
    }

    public void setResult(E result) {
        this.result = result;
    }
}