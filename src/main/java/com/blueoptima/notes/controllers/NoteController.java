package com.blueoptima.notes.controllers;

import com.blueoptima.notes.dao.NoteDao;
import com.blueoptima.notes.models.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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
    public void updateNote(@Valid @PathVariable int noteId, @RequestBody Note note) {
        String title = note.getTitle();
        String content = note.getContent();

        if (noteDao.getNote(noteId) == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't modify note: Note with ID: " + noteId + " not found");
        if (title == null || title.isEmpty() || title.trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't modify note: The title of the note must not be empty");
        if (content == null || content.isEmpty() || content.trim().isEmpty()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't modify note: The content of the note must not be empty");

        noteDao.updateNote(noteId, note);
    }

    @RequestMapping(path = "api/bulkUpdate/notes", method = RequestMethod.PUT)
    public void updateNotes() { noteDao.updateAllNotes(); }

    @RequestMapping(path = "api/notes/{noteId}", method = RequestMethod.DELETE)
    public void deleteNote(@PathVariable int noteId) {
        if (noteDao.getNote(noteId) == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete note: Note with ID: " + noteId + " not found");

        noteDao.deleteNote(noteId);
    }

    @RequestMapping(path = "api/notes", method = RequestMethod.DELETE)
    public void deleteNotes() { noteDao.deleteAllNotes(); }
}
