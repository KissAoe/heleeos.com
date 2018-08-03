package com.heleeos.blog.controller;

import com.heleeos.blog.bean.Result;
import com.heleeos.blog.dto.Manager;
import com.heleeos.blog.dto.Note;
import com.heleeos.blog.facede.NoteFacade;
import com.heleeos.blog.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 话题相关接口
 * Created by liyu on 2018/8/3.
 */
@RestController
@RequestMapping("/ajax/note")
public class NoteController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private NoteFacade noteFacade;

    /**
     * 查询话题列表
     */
    @GetMapping(value = "list.json")
    public Result<List<Note>> getList(Integer lastId, Integer count) {
        try {
            return ResultUtil.SUCCESS(noteFacade.getNoteList(lastId, count));
        } catch (Exception e) {
            logger.error("查询[话题列表]失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }

    /**
     * 保存话题
     */
    @PostMapping(value = "save")
    public Result<Boolean> saveBlog(@RequestBody Note note, @RequestAttribute Manager manager) {
        try {
            //1. 校验参数
            String errorMessage = noteFacade.checkNote(note);
            if (errorMessage != null) {
                return ResultUtil.PARAMETER_ERROR(errorMessage);
            }
            note.setManagerId(manager.getId());

            //2. 保存文章
            boolean success = noteFacade.saveNote(note);
            if (success) {
                return ResultUtil.SUCCESS();
            } else {
                return ResultUtil.FAILED("保存失败");
            }
        } catch (Exception e) {
            logger.error("保存[话题]失败, 失败原因:" + e.getMessage(), e);
            return ResultUtil.ERROR();
        }
    }
}
