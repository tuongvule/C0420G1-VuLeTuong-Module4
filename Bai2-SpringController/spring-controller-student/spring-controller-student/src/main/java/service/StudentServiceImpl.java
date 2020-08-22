package service;

import model.Student;
import repository.StudentRepository;
import repository.StudentRepositoryImpl;

import java.util.List;

public class StudentServiceImpl implements StudentService{
    StudentRepository studentRepository = new StudentRepositoryImpl();
    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    public void save(Student student) {
        this.studentRepository.save(student);
    }

    @Override
    public void delete(int id) {
        this.studentRepository.delete(id);
    }

    @Override
    public Student findById(int id) {
        return this.studentRepository.findById(id);
    }
}
