package com.blueoptima.notes.models;

import org.junit.jupiter.api.Test;

import java.time.LocalTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class NoteTest {

    @Test
    void getId() {
        int EXPECTED_ID= 10;

        Note NOTE = new Note();
        NOTE.setId(EXPECTED_ID);
        int RESULT = NOTE.getId();

        assertEquals(EXPECTED_ID, RESULT);
    }

    @Test
    void setId() {
        int NOTE_ID = 10;

        Note NOTE = new Note();
        NOTE.setId(NOTE_ID);

        assertEquals(NOTE.getId(), NOTE_ID);
    }

    @Test
    void getTitle() {
        String EXPECTED_TITLE = "New note title";

        Note NOTE = new Note();
        NOTE.setTitle(EXPECTED_TITLE);
        String RESULT = NOTE.getTitle();

        assertEquals(EXPECTED_TITLE, RESULT);
    }

    @Test
    void setTitle() {
        String TITLE = "New note title";

        Note NOTE = new Note();
        NOTE.setTitle(TITLE);

        assertEquals(NOTE.getTitle(), TITLE);
    }
    @Test
    void setTitle_empty() {
        String TITLE = "Not empty title";

        Note NOTE = new Note();
        NOTE.setTitle(TITLE);

        assertFalse(NOTE.getTitle().isEmpty());
    }

    @Test
    void getContent() {
        String EXPECTED_CONTENT = "Note content";

        Note NOTE = new Note();
        NOTE.setContent(EXPECTED_CONTENT);
        String RESULT = NOTE.getContent();

        assertEquals(EXPECTED_CONTENT, RESULT);
    }

    @Test
    void setContent() {
        String CONTENT = "Note content";

        Note NOTE = new Note();
        NOTE.setContent(CONTENT);

        assertEquals(NOTE.getContent(), CONTENT);
    }

    @Test
    void setContent_empty() {
        String CONTENT = "Content not empty";

        Note NOTE = new Note();
        NOTE.setContent(CONTENT);

        assertFalse(NOTE.getContent().isEmpty());
    }

    @Test
    void getCreatedAt() {
        LocalTime CURRENT_TIME = LocalTime.now();

        Note NOTE = new Note();
        NOTE.setCreatedAt(CURRENT_TIME);
        LocalTime EXPECTED_TIME = NOTE.getCreatedAt();

        assertEquals(EXPECTED_TIME, CURRENT_TIME);
    }

    @Test
    void setCreatedAt() {
        LocalTime CURRENT_TIME = LocalTime.now();

        Note NOTE = new Note();
        NOTE.setCreatedAt(CURRENT_TIME);

        assertEquals(NOTE.getCreatedAt(), CURRENT_TIME);
    }

    @Test
    void getUpdatedAt() {
        LocalTime CURRENT_TIME = LocalTime.now();

        Note NOTE = new Note();
        NOTE.setUpdatedAt(CURRENT_TIME);
        LocalTime EXPECTED_TIME = NOTE.getUpdatedAt();

        assertEquals(EXPECTED_TIME, CURRENT_TIME);
    }

    @Test
    void setUpdatedAt() {
        LocalTime CURRENT_TIME = LocalTime.now();

        Note NOTE = new Note();
        NOTE.setUpdatedAt(CURRENT_TIME);

        assertEquals(NOTE.getUpdatedAt(), CURRENT_TIME);
    }

    @Test
    void testToString() {
        Note NOTE = new Note(1,"Note 1","Content");
        NOTE.setCreatedAt(LocalTime.parse("03:10:06"));
        NOTE.setUpdatedAt(LocalTime.parse("03:10:06"));

        assertEquals(NOTE.toString(),"Note{id=1, title='Note 1', content='Content', createdAt=03:10:06, updatedAt=03:10:06}");
    }
}