package com.xzy_212306259.demo.common;

public enum ResultCode {

    SUCCESS(200, "操作成功"),
    UNAUTHORIZED(401, "登录权限错误"),
    SYSTEM_BUSY(500, "系统繁忙");
    private final Integer code;
    private final String message;
    ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    public Integer getCode() {
        return code;
    }
    public String getMsg() {
        return message;
    }
}