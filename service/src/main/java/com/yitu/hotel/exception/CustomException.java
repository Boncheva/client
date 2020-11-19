package com.yitu.hotel.exception;

/**
 * @version 1.0
 * @author: zouhao
 * @Date: 2020/11/18
 */
public class CustomException extends RuntimeException {

    private int code;

    public CustomException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public CustomException(String msg) {
        super(msg);
    }

}
