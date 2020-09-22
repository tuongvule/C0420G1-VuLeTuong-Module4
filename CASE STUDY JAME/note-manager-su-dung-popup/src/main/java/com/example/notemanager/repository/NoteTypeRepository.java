package com.example.notemanager.repository;

import com.example.notemanager.model.NoteType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteTypeRepository extends JpaRepository<NoteType, Integer> {
}
