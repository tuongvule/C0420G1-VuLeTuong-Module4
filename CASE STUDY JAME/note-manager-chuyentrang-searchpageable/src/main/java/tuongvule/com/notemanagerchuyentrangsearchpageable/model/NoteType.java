package tuongvule.com.notemanagerchuyentrangsearchpageable.model;


import javax.persistence.*;
import java.util.List;

@Entity
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    String name;

    @OneToMany(mappedBy = "noteType")
    List<Note> noteList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Note> getNoteList() {
        return noteList;
    }

    public void setNoteList(List<Note> noteList) {
        this.noteList = noteList;
    }
}
