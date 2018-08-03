package com.heleeos.blog.bean;

import com.google.gson.Gson;

import java.io.Serializable;

/**
 * 公共bean
 * Created by liyu on 2018/8/3.
 */
public class BaseBean implements Serializable {

    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
