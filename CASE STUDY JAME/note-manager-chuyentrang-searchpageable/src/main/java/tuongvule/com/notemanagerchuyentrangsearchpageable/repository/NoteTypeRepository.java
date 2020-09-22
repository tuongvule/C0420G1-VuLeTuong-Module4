package tuongvule.com.notemanagerchuyentrangsearchpageable.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tuongvule.com.notemanagerchuyentrangsearchpageable.model.NoteType;

public interface NoteTypeRepository extends JpaRepository<NoteType, Integer> {
}
