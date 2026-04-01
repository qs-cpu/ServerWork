package com.xzy_212306259.demo.common;

public class Result<T> {
    private Integer code;
    private T data;
    private String msg;

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = ResultCode.SUCCESS.getCode();
        result.msg = ResultCode.SUCCESS.getMsg();
        result.data = data;
        return result;
    }

    public static <T> Result<T> error(ResultCode resultCode) {
    Result<T> result = new Result<>();
    result.code = resultCode.getCode();
    result.msg = resultCode.getMsg();
    result.data = null;
    return result;
    }
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }
    
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    
    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }
}