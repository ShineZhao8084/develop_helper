package com.asiainfo.dh.core.enums;

public enum ResultInfo {
    SUCCESS(1000, "SUCCESS"),
    UNKNOWNEXCEPTION(2001, "THIS IS AN UNKNOWN EXCEPTION");

    private int code;
    private String msg;

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

    ResultInfo(int code, String msg){
        this.code = code;
        this.msg = msg;
    }
}
