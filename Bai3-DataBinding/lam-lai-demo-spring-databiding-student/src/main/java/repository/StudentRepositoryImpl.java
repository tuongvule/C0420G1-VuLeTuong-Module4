package repository;

import model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepositoryImpl implements StudentRepository{
    private static final Map<Integer,Student> students;
    static{
        students = new HashMap<>();
        students.put(1,new Student(1,"Thinh1", 21, "Nam"));
        students.put(2,new Student(2,"Thinh2", 22, "Nam"));
        students.put(3,new Student(3,"Thinh3", 23, "Nam"));
        students.put(4,new Student(4,"Thinh4", 24, "Nam"));
        students.put(5,new Student(5,"Thinh5", 25, "Nam"));
        students.put(6,new Student(6,"Thinh6", 26, "Nam"));
        students.put(7,new Student(7,"Thinh7", 27, "Nam"));
    }
    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students.values());
    }

    @Override
    public void save(Student student) {
        students.put(student.getId(),student);
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
