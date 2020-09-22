package com.example.notemanager.service.impl;

import com.example.notemanager.model.Note;
import com.example.notemanager.repository.NoteRepository;
import com.example.notemanager.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;


    @Override
    public Page<Note> findAllNote(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void remove(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteNote(int id) {
        noteRepository.deleteNote(id);
    }
}
