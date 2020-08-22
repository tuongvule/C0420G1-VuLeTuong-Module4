package repository;

import model.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class StudentRepositoryImpl implements StudentRepository {
    private static final Map<Integer, Student> students;

    static {
        students = new HashMap<>();
        students.put(1, new Student(1,"Thinh1", 25, "Name"));
        students.put(2, new Student(2, "Thinh2", 25, "Name"));
        students.put(3, new Student(3,"Thinh3", 25, "Name"));
        students.put(4, new Student(4, "Thinh4", 25, "Name"));
        students.put(5, new Student(5, "Thinh5", 25, "Name"));
        students.put(6, new Student(6,"Thinh6", 25, "Name"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(), student);
    }

    @Override
    public void delete(int id) {
        students.remove(id);
    }

    @Override
    public Student findById(int id) {
        return students.get(id);
    }
}
