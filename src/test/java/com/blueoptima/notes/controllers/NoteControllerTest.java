package com.blueoptima.notes.controllers;

import com.blueoptima.notes.dao.NoteDaoImp;
import com.blueoptima.notes.models.Note;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import javax.persistence.PersistenceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(NoteController.class)
class NoteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper mapper;

    @MockBean
    private NoteDaoImp noteDaoImp;

    private final Note NOTE_1 = new Note( 1, "Note title 1", "Note content 1");
    private final Note NOTE_2 = new Note( 2, "Note title 2", "Note content 2");
    private final Note NOTE_3 = new Note( 3, "Note title 3", "Note content 3");
    private final Note NOTE_MODIFIED = new Note(4, "Five note", "Content of the note");
    private final Note NOTE_DELETED = new Note(5, "Five note", "Content of the note");

    @Test
    public void getNotes_success() throws Exception {
        List<Note> NOTES = new ArrayList<>(Arrays.asList(NOTE_1, NOTE_2, NOTE_3));

        when(noteDaoImp.getNotes()).thenReturn(NOTES);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/notes")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(3)))
                .andExpect(jsonPath("$[2].title", is("Note title 3")));
    }

    @Test
    public void getNote_success() throws Exception {
        when(noteDaoImp.getNote(NOTE_1.getId())).thenReturn(NOTE_1);

        mockMvc.perform(MockMvcRequestBuilders
                        .get("/api/notes/" + NOTE_1.getId())
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$.title", is("Note title 1")));
    }

    @Test
    public void createNote_success() throws Exception {
        Mockito.doThrow(new PersistenceException()).when(noteDaoImp).createNote(NOTE_1);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/api/notes")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(NOTE_1));

        mockMvc.perform(mockRequest)
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void updateNote_success() throws Exception {
        when(noteDaoImp.getNote(NOTE_MODIFIED.getId())).thenReturn(NOTE_MODIFIED);
        Mockito.doThrow(new PersistenceException()).when(noteDaoImp).updateNote(NOTE_MODIFIED.getId(), NOTE_MODIFIED);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/notes/"+NOTE_MODIFIED.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(NOTE_MODIFIED));

        mockMvc.perform(mockRequest)
                .andExpect(status().isOk());
    }

    @Test
    public void updateNote_nullId() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/notes/"+NOTE_MODIFIED.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(NOTE_MODIFIED));

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals("404 NOT_FOUND \"Can't modify note: Note with ID: " + NOTE_MODIFIED.getId() + " not found\"", result.getResolvedException().getMessage()));
    }

    @Test
    public void updateNote_recordNotFound() throws Exception {
        when(noteDaoImp.getNote(NOTE_MODIFIED.getId())).thenReturn(null);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/notes/"+NOTE_MODIFIED.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(this.mapper.writeValueAsString(NOTE_MODIFIED));

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals("404 NOT_FOUND \"Can't modify note: Note with ID: " + NOTE_MODIFIED.getId() + " not found\"", result.getResolvedException().getMessage()));
    }

    @Test
    public void updateNotes_success() throws Exception {
        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.put("/api/bulkUpdate/notes");

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void deleteNote_success() throws Exception {
        when(noteDaoImp.getNote(NOTE_DELETED.getId())).thenReturn(NOTE_DELETED);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/notes/" + NOTE_DELETED.getId()).contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

    @Test
    public void deleteNote_recordNotFound() throws Exception {
        when(noteDaoImp.getNote(NOTE_DELETED.getId())).thenReturn(null);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/notes/"+NOTE_DELETED.getId());

        mockMvc.perform(mockRequest)
                .andExpect(status().isNotFound())
                .andExpect(result ->
                        assertEquals("404 NOT_FOUND \"Can't delete note: Note with ID: " + NOTE_DELETED.getId() + " not found\"", result.getResolvedException().getMessage()));
    }

    @Test
    public void deleteNotes_success() throws Exception {
        when(noteDaoImp.getNote(NOTE_DELETED.getId())).thenReturn(NOTE_DELETED);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.delete("/api/notes/").contentType(MediaType.APPLICATION_JSON);

        mockMvc.perform(mockRequest).andExpect(status().isOk());
    }

}