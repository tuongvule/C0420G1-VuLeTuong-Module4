package tuongvule.com.notemanagerchuyentrangsearchpageable.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.Note;
import tuongvule.com.notemanagerchuyentrangsearchpageable.repository.NoteRepository;
import tuongvule.com.notemanagerchuyentrangsearchpageable.service.NoteService;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NoteRepository noteRepository;
    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllSearch(String keyword, Pageable pageable) {
        return noteRepository.findAllSearch(keyword,pageable);
    }

    @Override
    public Note findNoteById(int id) {
        return noteRepository.findById(id).orElse(null);
    }

//    @Override
//    public Page<Note> findAllByIdandAndAndTitleContainingAndAndContentContainingAndNoteTypeContaining(Integer id, String title, String content, String notetype, Pageable p) {
//        return this.noteRepository.findAllByIdandAndAndTitleContainingAndAndContentContainingAndNoteTypeContaining(id,title,c);
//    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);
    }

    @Override
    public void deleteById(int id) {
        noteRepository.deleteById(id);
    }

    @Override
    public void deleteNote(int id) {
        noteRepository.deleteNote(id);
    }

    @Override
    public Page<Note> searchAllByHSQL(String keyword, Pageable pageable) {
        return noteRepository.searchAllByHSQL(keyword, pageable);
    }
}
