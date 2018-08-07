package com.heleeos.blog.dao;

import com.heleeos.blog.dto.Topic;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TopicMapper {

    /**
     * 获取每日记录
     * @param id id
     */
    Topic get(Integer id);

    /**
     * 查询每日记录
     * @param lastId 最近一条的ID
     * @param rows 要查询的个数
     */
    List<Topic> getList(@Param("lastId") Integer lastId, @Param("rows") Integer rows);

    /**
     * 新增每日记录
     * @param topic 笔记
     */
    int insert(Topic topic);

    /**
     * 更新每日记录
     * @param topic 笔记
     */
    int update(Topic topic);
}
