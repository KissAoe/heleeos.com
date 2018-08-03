package com.heleeos.blog.service;

import com.heleeos.blog.dao.NoteMapper;
import com.heleeos.blog.dto.Note;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

/**
 * 笔记数据服务层, t_note.
 * Created with Li Yu on 2018/08/01.
 *
 * @author liyu
 * @author kissaoe@gmail.com
 * @version 1.0.0
 */
@Service
public class NoteService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NoteMapper noteMapper;

    /**
     * 保存每日记录.
     *
     * @param note 每日记录
     */
    public boolean save(Note note) {
        if(note == null) return false;
        try {
            if(note.getId() == null || note.getId() == 0) {
                return noteMapper.insert(note) == 1;
            } else {
                return noteMapper.update(note) == 1;
            }
        } catch (Exception e) {
            logger.error(String.format("保存[每日笔记]异常,原因:%s", e.getMessage()), e);
            return false;
        }
    }

    /**
     * 查询每日记录列表.
     *
     * @param lastId 最近一条的ID
     * @param rows 显示条数
     */
    public List<Note> getList(Integer lastId, Integer rows) {
        if(lastId == null) lastId = 0;
        if(rows == null) rows = 10;
        try {
            return noteMapper.getNoteList(lastId, rows);
        } catch (Exception e) {
            logger.error(String.format("查询[每日笔记]列表异常,原因:%s", e.getMessage()), e);
            return new LinkedList<>();
        }
    }
}
