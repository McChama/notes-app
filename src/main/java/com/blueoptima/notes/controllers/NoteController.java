package com.blueoptima.notes.controllers;

import com.blueoptima.notes.dao.NoteDao;
import com.blueoptima.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
public class NoteController {

    @Autowired
    NoteDao noteDao;

    @RequestMapping(path = "api/notes/{noteId}", method = RequestMethod.GET)
    public Note getNote(@PathVariable int noteId) { return noteDao.getNote(noteId); }

    @RequestMapping(path = "api/notes", method = RequestMethod.GET)
    public List<Note> getNotes() { return noteDao.getNotes(); }

    @RequestMapping(path = "api/notes", method = RequestMethod.POST)
    public void createNote(@Valid @RequestBody Note note) { noteDao.createNote(note); }

    @RequestMapping(path = "api/notes/{noteId}", method = RequestMethod.PUT)
    public void updateNote(@Valid @PathVariable int noteId, @RequestBody Note note) { noteDao.updateNote(noteId, note); }

    @RequestMapping(path = "api/bulkUpdate/notes", method = RequestMethod.PUT)
    public void updateNotes() { noteDao.updateAllNotes(); }

    @RequestMapping(path = "api/notes/{noteId}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable int noteId) {
        noteDao.deleteNote(noteId);
    }

    @RequestMapping(path = "api/notes", method = RequestMethod.DELETE)
    public void deleteNotes() { noteDao.deleteAllNotes(); }
}
