package tuongvule.com.notemanagerchuyentrangsearchpageable.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.Note;

public interface NoteService {
    Page<Note> findAll (Pageable pageable);
    Page<Note> findAllSearch(@Param("keyword") String keyword, Pageable pageable);
    Note findNoteById(int id);
    void save(Note note);
    // delete in database
    void deleteById(int id);
    // Don't delete in database
    void deleteNote(int id);

    //Search All dùng @Query HSQL
    Page<Note> searchAllByHSQL(String keyword, Pageable pageable);
}
