package com.blueoptima.notes.dao;

import com.blueoptima.notes.models.Note;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import java.time.LocalTime;
import java.util.List;

@Repository
@Transactional
public class NoteDaoImp implements NoteDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public Note getNote(int noteId) {
        String query = "FROM Note WHERE id=" + noteId;
        try {
            return (Note) entityManager.createQuery(query).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    @Override
    @Transactional
    public List<Note> getNotes() {
        String query = "FROM Note";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public void createNote(Note note) {
        LocalTime now = LocalTime.now();

        note.setCreatedAt(now);
        note.setUpdatedAt(now);
        entityManager.merge(note);
    }

    @Override
    public void updateNote(int noteId, Note modifyNote) {
        Note note = (Note) entityManager.find(Note.class, noteId);
        LocalTime now = LocalTime.now();

        note.setTitle(modifyNote.getTitle());
        note.setContent(modifyNote.getContent());
        note.setUpdatedAt(now);
    }

    @Override
    public void updateAllNotes() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaUpdate<Note> update = criteriaBuilder.createCriteriaUpdate(Note.class);
        Root<Note> root = update.from(Note.class);
        LocalTime now = LocalTime.now();

        update.set("updatedAt", now);
        entityManager.createQuery(update).executeUpdate();
    }

    @Override
    public void deleteNote(int noteId) {
        Note note = (Note) entityManager.find(Note.class, noteId);
        entityManager.remove(note);
    }

    @Override
    public void deleteAllNotes() {
        String hql = "DELETE FROM Note";
        entityManager.createQuery(hql).executeUpdate();
    }


}
