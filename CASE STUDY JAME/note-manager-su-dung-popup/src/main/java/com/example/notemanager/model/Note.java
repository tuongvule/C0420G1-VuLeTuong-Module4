package com.example.notemanager.model;


import javax.persistence.*;

@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String content;

    @ManyToOne
    @JoinColumn(name = "note_type_id")
    private NoteType noteType;

    @Column(name = "delete_note", columnDefinition = "integer default 0" )
    private int deleteNote;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
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

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public int getDeleteNote() {
        return deleteNote;
    }

    public void setDeleteNote(int deleteNote) {
        this.deleteNote = deleteNote;
    }
}
