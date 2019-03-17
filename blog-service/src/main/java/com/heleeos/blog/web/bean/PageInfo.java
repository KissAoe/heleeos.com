package com.heleeos.blog.web.bean;

import lombok.Data;

import java.util.List;

/**
 * 分页
 * Created by liyu on 2018/4/22.
 */
@Data
public class PageInfo<T> {
    /** 当前页码 */
    private int page;
    /** 当前个数 */
    private int rows;
    /** 总的个数 */
    private long count;
    /** 展示对象 */
    private List<T> beans;
}
