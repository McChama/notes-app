package com.blueoptima.notes.dao;

import com.blueoptima.notes.models.Note;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class NoteDaoImpTest {

    @Autowired
    private NoteDaoImp noteDaoImp;

    @BeforeEach
    void initUseCase() {
        Note NOTE = new Note(5, "Note title 5", "Random content");
        noteDaoImp.createNote(NOTE);
    }

    @AfterEach
    public void destroyAll(){
        noteDaoImp.deleteAllNotes();
    }

    @Test
    void getNote_success() {
        List<Note> NOTES = noteDaoImp.getNotes();
        Note noteToSearch = NOTES.get(0);
        Note noteResult = noteDaoImp.getNote(noteToSearch.getId());

        assertThat(noteResult).isNotNull();
    }

    @Test
    void getNotes_success() {
        List<Note> ALL_NOTES = noteDaoImp.getNotes();

        assertThat(ALL_NOTES.size()).isGreaterThanOrEqualTo(1);
    }

    @Test
    void updateNote_success() throws InterruptedException {
        List<Note> ALL_NOTES = noteDaoImp.getNotes();
        Note noteBeforeUpdate = ALL_NOTES.get(0);

        /* Wait 1 sec to update the updateAt time */
        TimeUnit.SECONDS.sleep(1);

        Note noteAfterUpdate = noteDaoImp.updateNote(noteBeforeUpdate.getId(), noteBeforeUpdate);

        assertNotEquals(noteBeforeUpdate, noteAfterUpdate);
    }

    @Test
    void updateNotes_success(){
        List<Note> ALL_NOTES = noteDaoImp.getNotes();
        int NOTES_MODIFIED = noteDaoImp.updateAllNotes();

        assertEquals(NOTES_MODIFIED, ALL_NOTES.size());
    }

    @Test
    void deleteNote_success(){
        List<Note> ALL_NOTES = noteDaoImp.getNotes();
        Note noteBeforeDelete = ALL_NOTES.get(0);

        noteDaoImp.deleteNote(noteBeforeDelete.getId());
        Note noteAfterDelete = noteDaoImp.getNote(noteBeforeDelete.getId());

        assertThat(noteAfterDelete).isNull();
    }

    @Test
    void deleteNotes_success(){
        List<Note> ALL_NOTES = noteDaoImp.getNotes();
        int NOTES_DELETED = noteDaoImp.deleteAllNotes();

        assertEquals(NOTES_DELETED, ALL_NOTES.size());
    }
}