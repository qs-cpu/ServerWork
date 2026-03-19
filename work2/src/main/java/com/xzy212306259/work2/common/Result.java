package com.xzy212306259.work2.common;

import java.io.Serializable;

/**
 * 企业级统一响应体泛型类
 * 提供标准化的RESTful API响应格式
 * 
 * @param <T> 响应数据类型
 */
public class Result<T> implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    // ==================== 核心属性 ====================
    
    /**
     * 状态码
     */
    private Integer code;
    
    /**
     * 提示信息
     */
    private String message;
    
    /**
     * 核心数据
     */
    private T data;
    
    // ==================== 状态码常量 ====================
    
    /** 成功状态码 */
    public static final int SUCCESS = 200;
    
    /** 客户端错误状态码 */
    public static final int BAD_REQUEST = 400;
    public static final int UNAUTHORIZED = 401;
    public static final int FORBIDDEN = 403;
    public static final int NOT_FOUND = 404;
    
    /** 服务器错误状态码 */
    public static final int INTERNAL_SERVER_ERROR = 500;
    
    // ==================== 构造方法 ====================
    
    /**
     * 无参构造方法
     */
    public Result() {
    }
    
    /**
     * 全参构造方法
     */
    public Result(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
    
    // ==================== 成功响应静态方法 ====================
    
    /**
     * 成功响应（无数据）
     */
    public static <T> Result<T> success() {
        return new Result<>(SUCCESS, "操作成功", null);
    }
    
    /**
     * 成功响应（自定义消息）
     */
    public static <T> Result<T> success(String message) {
        return new Result<>(SUCCESS, message, null);
    }
    
    /**
     * 成功响应（带数据）
     */
    public static <T> Result<T> success(T data) {
        return new Result<>(SUCCESS, "操作成功", data);
    }
    
    /**
     * 成功响应（自定义消息和数据）
     */
    public static <T> Result<T> success(String message, T data) {
        return new Result<>(SUCCESS, message, data);
    }
    
    // ==================== 错误响应静态方法 ====================
    
    /**
     * 错误响应（默认消息）
     */
    public static <T> Result<T> error() {
        return new Result<>(INTERNAL_SERVER_ERROR, "操作失败", null);
    }
    
    /**
     * 错误响应（自定义消息）
     */
    public static <T> Result<T> error(String message) {
        return new Result<>(INTERNAL_SERVER_ERROR, message, null);
    }
    
    /**
     * 错误响应（自定义状态码和消息）
     */
    public static <T> Result<T> error(Integer code, String message) {
        return new Result<>(code, message, null);
    }
    
    /**
     * 错误响应（带数据）
     */
    public static <T> Result<T> error(String message, T data) {
        return new Result<>(INTERNAL_SERVER_ERROR, message, data);
    }
    
    // ==================== 常用错误类型快捷方法 ====================
    
    /**
     * 参数错误响应
     */
    public static <T> Result<T> badRequest(String message) {
        return new Result<>(BAD_REQUEST, message, null);
    }
    
    /**
     * 未授权响应
     */
    public static <T> Result<T> unauthorized(String message) {
        return new Result<>(UNAUTHORIZED, message, null);
    }
    
    /**
     * 禁止访问响应
     */
    public static <T> Result<T> forbidden(String message) {
        return new Result<>(FORBIDDEN, message, null);
    }
    
    /**
     * 资源不存在响应
     */
    public static <T> Result<T> notFound(String message) {
        return new Result<>(NOT_FOUND, message, null);
    }
    
    // ==================== Getter和Setter方法 ====================
    
    public Integer getCode() {
        return code;
    }
    
    public void setCode(Integer code) {
        this.code = code;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getData() {
        return data;
    }
    
    public void setData(T data) {
        this.data = data;
    }
    
    // ==================== 工具方法 ====================
    
    /**
     * 判断响应是否成功
     */
    public boolean isSuccess() {
        return SUCCESS == this.code;
    }
    
    /**
     * 转换为字符串表示
     */
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}