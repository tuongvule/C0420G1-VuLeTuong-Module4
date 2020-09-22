package com.example.notemanager.service;

import com.example.notemanager.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface NoteService {
    Page<Note> findAllNote(Pageable pageable);
    Note findNoteById(int id);
    void save(Note note);
    void remove(int id);
    void deleteNote(int id);
}
