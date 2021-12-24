package com.blueoptima.notes;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.blueoptima.notes.controllers.NoteController;

@SpringBootTest
class NotesApplicationTest {

    @Autowired
    private NoteController controller;

    @Test
    public void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }

}