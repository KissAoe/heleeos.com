package com.heleeos.blog.util;

import com.heleeos.blog.web.bean.Result;

import java.util.HashMap;
import java.util.Map;

/**
 * 结果集构造工具
 * Created by liyu on 2018/6/18.
 */
public class ResultUtil {

    /**
     * 构建一个返回体
     * @param code 返回码
     * @param message 返回消息
     * @param data 返回的数据
     */
    public static <T> Result<T> of(int code, String message, T data) {
        Result<T> result = new Result<>();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }

    /**
     * 构建一个空数据的返回体
     * @param code 返回码
     * @param message 返回消息
     */
    public static <T> Result<T> of(int code, String message) {
        return of(code, message, null);
    }

    /**
     * 根据布尔类型构建
     * @param success 是否成功
     */
    public static <T> Result<T> of(boolean success) {
        if(success) {
            return success();
        } else {
            return failed();
        }
    }

    /**
     * 构建一个Map
     * @param code 返回码
     * @param message 返回信息
     * @param keyAndValue map的 key,value 组合
     */
    public static Result<Map<Object, Object>> ofMap(int code, String message, Object...keyAndValue) {
        Map<Object, Object> map = new HashMap<>();
        if(keyAndValue.length % 2 != 0) {
            return of(code, message, map);
        } else {
            for(int i = 0; i < keyAndValue.length; i = i + 2) {
                map.put(keyAndValue[i], keyAndValue[i + 1]);
            }
            return of(code, message, map);
        }
    }

    /**
     * 构建一个成功的返回体
     */
    public static <T> Result<T> success() {
        return of(200, "操作成功", null);
    }

    /**
     * 构建一个带数据的成功返回体
     * @param data 数据
     */
    public static <T> Result<T> success(T data) {
        return of(200, "操作成功", data);
    }

    /**
     * 构建一个带数据的成功返回体
     */
    public static <T> Result<T> empty() {
        return of(200, "数据为空", null);
    }

    /**
     * 构建一个参数错误的返回体
     * @param message 提示信息
     */
    public static <T> Result<T> parameterError(String message) {
        return of(300, message, null);
    }

    /**
     * 构建一个登录失败的返回体
     */
    public static <T> Result<T> tokenError() {
        return of(301, "登录失效", null);
    }

    /**
     * 构建一个权限失败的返回体
     */
    public static <T> Result<T> authError() {
        return of(302, "没有权限", null);
    }

    /**
     * 构建一个业务错误的返回体
     */
    public static <T> Result<T> failed() {
        return of(400, "操作失败", null);
    }

    /**
     * 构建一个业务错误的返回体
     */
    public static <T> Result<T> failed(String message) {
        return of(400, message, null);
    }

    /**
     * 构建一个系统错误的返回体
     */
    public static <T> Result<T> error() {
        return of(500, "系统错误", null);
    }
}
