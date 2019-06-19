package com.jesper.model;

import java.io.Serializable;

public class ResultSet implements Serializable {

    public static final String RS_SUCCESS = "0000";

    public static final String RS_FAILURE = "404";

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

}
