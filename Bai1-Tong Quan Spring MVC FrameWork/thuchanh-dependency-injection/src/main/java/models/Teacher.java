package models;

import org.springframework.stereotype.Component;


public class Teacher {
    private Student student;

    public Teacher() {
    }

    public Teacher(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "student=" + student +
                '}';
    }
}
