package tuongvule.com.notemanagerchuyentrangsearchpageable.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer> {

    // Tìm kiếm sử dụng  câu Query nativeQuery ( câu query thuần)
    @Query(value="select * from note where delete_note = 0", nativeQuery= true)
    Page<Note> findAll (Pageable pageable);

//    @Query(value = "select * from note where delete_note = 0",nativeQuery = true)
//    Page<Note> findAllSearch(@Param("keyword") String keyword, Pageable pageable);

    @Query(value = "select * from note where title like %:keyword% or content like %:keyword% and delete_note = 0",nativeQuery = true)
    Page<Note> findAllSearch(@Param("keyword") String keyword, Pageable pageable);

//    @Query(value = "SELECT b FROM Blog b WHERE b.title like %?1% OR b.content like %?1% or b.likes like %?1% or b.category.name like %?1%")
//    Page<Blog> searchAll(String val, Pageable pageable);


    // Tìm kiếm sử dụng  câu Query HSQL
    @Query(value = "SELECT n FROM Note n WHERE ( n.title like %?1% OR n.noteType.name like %?1% or n.content like %?1% ) and n.deleteNote = 0")
    Page<Note> searchAllByHSQL(String keyword, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="update note set delete_note = 1 where id=?", nativeQuery= true)
    void deleteNote(int id);
}
