package com.heleeos.blog.exception;

/**
 *
 * Created by liyu on 2018/7/13.
 */
public class ServiceException extends Exception {

    private int code;

    private String message;

    public ServiceException(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
