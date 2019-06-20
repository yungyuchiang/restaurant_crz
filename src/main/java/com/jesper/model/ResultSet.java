package com.jesper.model;

import java.io.Serializable;

public class ResultSet implements Serializable {

    public static final String RS_SUCCESS = "0000";

    public static final String RS_FAILURE = "404";

    public static final String RS_FAILURE_AUTH = "400";

    private String code;

    private String message;

    private Object obj;

    public ResultSet(String code, String message, Object obj) {
        this.code = code;
        this.message = message;
        this.obj = obj;
    }

    public static ResultSet Success (String message) {
        return new ResultSet(RS_SUCCESS, message, null);
    }

    public static ResultSet Failure (String message) {
        return new ResultSet(RS_FAILURE, message, null);
    }

    public static ResultSet Failure_Auth (String message) {
        return new ResultSet(RS_FAILURE_AUTH, message, null);
    }

    public static ResultSet Success_Login (String token) {
        return new ResultSet(RS_SUCCESS, "登录成功", token);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "ResultSet{" +
                "code='" + code + '\'' +
                ", messge='" + message + '\'' +
                ", obj=" + obj +
                '}';
    }
}
