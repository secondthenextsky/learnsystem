package com.learnsystem.common;

public class Result<T> {
    public static final int LOGIN_SUCCESS = 100;
    public static final int LOGIN_FAIL = 101;
    public static final int HANDLE_SUCCESS = 200;
    public static final int HANDLE_FAIL = 201;

    private int code;
    private T data;

    public Result(int code, T data) {
        this.code = code;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", data=" + data +
                '}';
    }
}
