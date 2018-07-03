package com.heleeos.blog.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;

/**
 * 前后端交互的结果集.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 4466004470986993081L;

    /** 结果返回码 */
    private int code;
    /** 结果返回的消息 */
    private String message;
    /** 结果返回的数据 */
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
