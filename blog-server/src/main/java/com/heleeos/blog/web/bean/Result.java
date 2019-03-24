package com.heleeos.blog.web.bean;

import com.google.gson.Gson;
import lombok.Data;

/**
 * 前后端交互的结果集.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 */
@Data
public class Result<T> {

    /**
     * 结果返回码
     */
    private int code;
    /**
     * 结果返回的消息
     */
    private String message;
    /**
     * 结果返回的数据
     */
    private T data;

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
