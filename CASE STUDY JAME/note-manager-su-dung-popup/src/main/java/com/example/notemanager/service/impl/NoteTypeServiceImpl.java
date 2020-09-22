package com.example.notemanager.service.impl;


import com.example.notemanager.model.NoteType;
import com.example.notemanager.repository.NoteTypeRepository;
import com.example.notemanager.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    NoteTypeRepository noteTypeRepository;
    @Override
    public List<NoteType> findAllNoteType() {
        return noteTypeRepository.findAll();
    }
}
