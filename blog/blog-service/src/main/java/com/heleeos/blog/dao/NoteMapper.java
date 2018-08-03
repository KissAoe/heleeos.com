package com.heleeos.blog.dao;

import com.heleeos.blog.dto.Note;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoteMapper {

    /**
     * 获取每日记录
     * @param id id
     */
    Note get(Integer id);

    /**
     * 查询每日记录
     * @param lastId 最近一条的ID
     * @param rows 要查询的个数
     */
    List<Note> getNoteList(@Param("lastId") Integer lastId, @Param("rows") Integer rows);

    /**
     * 新增每日记录
     * @param note 笔记
     */
    int insert(Note note);

    /**
     * 更新每日记录
     * @param note 笔记
     */
    int update(Note note);
}
