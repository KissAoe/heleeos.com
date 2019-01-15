package com.heleeos.blog.dao;

import java.util.List;

public interface BaseMapper<T> {
    
    /** 实体对象作为查询条件 */
    List<T> selectByDomain(T domain);

    T selectByPrimaryKey(int id);

    long countByDomain(T domain);
}