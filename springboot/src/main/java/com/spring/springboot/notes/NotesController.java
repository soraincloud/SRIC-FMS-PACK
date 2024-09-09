package com.spring.springboot.notes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * - - - - - - - - - -
 * notes 控制类
 * - - - - - - - - - -
 */

@CrossOrigin
@RestController
@RequestMapping("/notes")
public class NotesController
{
    @Autowired
    NotesService notesService;

    /**
     * @author SRIC
     *
     * 获取 notes 分页列表
     */
    @GetMapping("/getNotesList")
    public NotesResponsePojo getHComicList(NotesRequestPojo notesRequest)
    {
        NotesResponsePojo notesResponse = new NotesResponsePojo();
        notesResponse.setNotesList(notesService.getNotesList(notesRequest));
        notesResponse.setTotal(notesService.getNotesCount(notesRequest));
        return notesResponse;
    }

    /**
     * @author SRIC
     *
     * 根据 id 获取 notes 数据
     */
    @GetMapping("/getNotesById")
    public NotesDataResponsePojo getNotesById(Notes notes)
    {
        return notesService.getNotesById(notes.getId());
    }
}
