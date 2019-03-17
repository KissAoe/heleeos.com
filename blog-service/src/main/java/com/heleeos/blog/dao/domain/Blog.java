package com.heleeos.blog.dao.domain;

import lombok.Data;

import java.util.Date;

/**
 * 
 * Created by liyu on 2019/2/3
 */
@Data
public class Blog {
    /** 自增主键 */
    private Integer id;

    /** 文章标题 */
    private String blogTitle;

    /** 显示的URL */
    private String displayUrl;

    /** 摘要 */
    private String blogSummary;

    /** 所有的标签 */
    private String blogTags;

    /** 类型ID */
    private Integer blogType;

    /** 状态 */
    private Byte blogState;

    /** 发布者ID */
    private Integer managerId;

    /** 阅读次数 */
    private Integer readCount;

    /** 显示顺序 */
    private Byte sortIndex;

    /** 发布时间 */
    private Date createTime;

    /** 最后更新时间 */
    private Date updateTime;
}