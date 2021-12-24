package com.blueoptima.notes.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalTime;
import java.time.ZoneId;

@Entity
@Table(name = "NOTE")
public class Note {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "TITLE")
    @NotEmpty
    private String title;

    @Column(name = "CONTENT")
    @NotEmpty
    private String content;

    @Column(name = "CREATED_AT")
    private LocalTime createdAt;

    @Column(name = "UPDATED_AT")
    private LocalTime updatedAt;

    public Note(){

    }

    public Note(int id, String title, String content) {
        LocalTime now = LocalTime.now(ZoneId.of("America/Mexico_City"));
        this.id = id;
        this.title = title;
        this.content = content;
        this.createdAt = now;
        this.updatedAt = now;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
