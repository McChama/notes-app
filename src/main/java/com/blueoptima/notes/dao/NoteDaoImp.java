package com.blueoptima.notes.dao;

import com.blueoptima.notes.models.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;

@Repository
@Transactional
public class NoteDaoImp implements NoteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Note getNote(int noteId) { return entityManager.find(Note.class, noteId); }

    @Override
    public List<Note> getNotes() { return entityManager.createQuery("FROM Note").getResultList(); }

    @Override
    public void createNote(Note note) {
        LocalTime now = LocalTime.now(ZoneId.of("America/Mexico_City"));

        note.setCreatedAt(now);
        note.setUpdatedAt(now);

        entityManager.merge(note);

    }

    @Override
    public Note updateNote(int noteId, Note modifyNote) {
        Note note = entityManager.find(Note.class, noteId);
        LocalTime now = LocalTime.now(ZoneId.of("America/Mexico_City"));

        note.setTitle(modifyNote.getTitle());
        note.setContent(modifyNote.getContent());
        note.setUpdatedAt(now);

        return note;
    }

    @Override
    public int updateAllNotes() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Note> update = criteriaBuilder.createCriteriaUpdate(Note.class);
        LocalTime now = LocalTime.now(ZoneId.of("America/Mexico_City"));
        Root<Note> root = update.from(Note.class);

        update.set("updatedAt", now);
        return entityManager.createQuery(update).executeUpdate();
    }

    @Override
    public void deleteNote(int noteId) {
        Note note = entityManager.find(Note.class, noteId);
        entityManager.remove(note);
    }

    @Override
    public int deleteAllNotes() {
        return entityManager.createQuery("DELETE FROM Note").executeUpdate();
    }


}
