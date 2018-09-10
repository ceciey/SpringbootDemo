package com.invitation.card.utils;

public class ResultBean<T> {

    public static final Integer SUCCESS_CODE = 200;
    private static final String SUCCESS_MSG = "success";

    private Integer code;
    private String msg;
    private T data;

    public ResultBean(){
        this.code = SUCCESS_CODE;
        this.msg = SUCCESS_MSG;
    }

    public ResultBean(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultBean(String msg, T data) {
        super();
        this.msg = msg;
        this.data = data;
    }

    public ResultBean(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
