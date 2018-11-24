package com.lz.myspringboot.bean;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: LZ
 * @Date: 2018/11/24 12: 05
 */
@Data
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int NO_LOGIN = -1;

    public static final int SUCCESS = 1;

    public static final int FAIL = 0;

    public static final int NO_PERMISSION = 2;

    private String message = "success";

    private int code = SUCCESS;

    private T data;

    public ResultBean() {

    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable throwable) {
        super();
        this.message = throwable.getMessage();
        this.code = FAIL;
    }

    public ResultBean setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResultBean setCode(int code) {
        this.code = code;
        return this;
    }

    public ResultBean setData(T data) {
        this.data = data;
        return this;
    }
}
