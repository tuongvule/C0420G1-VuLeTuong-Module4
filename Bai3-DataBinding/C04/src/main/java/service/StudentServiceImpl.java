package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{

    StudentRepository studentRepository = new StudentRepositoryImpl();

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        studentRepository.delete(id);
    }

    @Override
    public Student findById(int id) {
        return studentRepository.findById(id);
    }
}
