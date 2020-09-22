package tuongvule.com.notemanagerchuyentrangsearchpageable.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.NoteType;
import tuongvule.com.notemanagerchuyentrangsearchpageable.repository.NoteRepository;
import tuongvule.com.notemanagerchuyentrangsearchpageable.repository.NoteTypeRepository;
import tuongvule.com.notemanagerchuyentrangsearchpageable.service.NoteTypeService;

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
