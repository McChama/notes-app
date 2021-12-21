package com.blueoptima.notes.dao;

import com.blueoptima.notes.models.Note;

import java.util.List;

public interface NoteDao {

    Note getNote(int noteId);

    List<Note> getNotes();

    void createNote(Note note);

    void updateNote(int noteId, Note note);

    void updateAllNotes();

    void deleteNote(int noteId);

    void deleteAllNotes();
}
