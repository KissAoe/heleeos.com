package com.heleeos.blog.common;

/**
 * 博客状态的枚举值.
 * Created with Li Yu on 2017/12/16.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.1
 */
public class BlogState {

    /** 初始状态 */
    public static final Byte INITIAL = 0;
    /** 删除状态 */
    public static final Byte DELETE  = 10;
    /** 草稿状态 */
    public static final Byte DRAFT   = 20;
    /** 审核状态 */
    public static final Byte REVIEW  = 30;
    /** 发布状态 */
    public static final Byte RELEASE = 40;
}
