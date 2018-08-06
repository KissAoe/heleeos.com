package com.heleeos.blog.test.service;

import com.heleeos.blog.dto.Note;
import com.heleeos.blog.service.NoteService;
import com.heleeos.blog.test.TestConfig;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestBlogService extends TestConfig {

    @Autowired
    private NoteService noteService;

    @Test
    public void saveNoteList() {
        for (int i = 1; i <= 100; i++) {
            Note note = new Note();
            note.setTitle("标题标题");
            note.setStatus(0);
            note.setManagerId(0);
            note.setContent("<p>内容内容</p><hr><p>123123</p>");
            noteService.save(note);
        }
    }
}
