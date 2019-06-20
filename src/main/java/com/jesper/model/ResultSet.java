package com.jesper.model;

import java.io.Serializable;

public class ResultSet implements Serializable {

    public static final String RS_SUCCESS = "0000";

    public static final String RS_FAILURE = "404";

    public static final String RS_FAILURE_AUTH = "400";

    private String code;

    private String messge;

    private Object obj;

    public ResultSet(String code, String messge, Object obj) {
        this.code = code;
        this.messge = messge;
        this.obj = obj;
    }

    public static ResultSet Success (String messge) {
        return new ResultSet(RS_SUCCESS, messge, null);
    }

    public static ResultSet Failure (String messge) {
        return new ResultSet(RS_FAILURE, messge, null);
    }

    public static ResultSet Failure_Auth (String messge) {
        return new ResultSet(RS_FAILURE_AUTH, messge, null);
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

    public String getMessge() {
        return messge;
    }

    public void setMessge(String messge) {
        this.messge = messge;
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
                ", messge='" + messge + '\'' +
                ", obj=" + obj +
                '}';
    }
}
