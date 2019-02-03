package com.heleeos.blog.dao;

import java.util.List;

public interface BaseMapper<T> {
    
    /** 根据主键查询实体 */
    T selectById(int id);

    /** 实体对象作为查询条件 */
    List<T> selectByDomain(T domain);

    /** 实体对象作为查询条件, 统计个数 */
    long countByDomain(T domain);

    /** 新增一个实体对象 */
    int insert(T domain);

    /** 根据主键进行更新实体对象 */
    int update(T domain);

    /** 根据主键删除实体对象 */
    int delete(int id);
}