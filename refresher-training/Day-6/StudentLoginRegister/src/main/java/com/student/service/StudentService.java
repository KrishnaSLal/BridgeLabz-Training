package com.student.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.model.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // CREATE
    public Student registerStudent(Student student) {
        return studentRepository.save(student);
    }

    // READ - Get all students
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // READ - Get student by ID
    public Student getStudentById(int id) {
        return studentRepository.findById(id).orElse(null);
    }

    // UPDATE
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    // DELETE
    public void deleteStudent(int id) {
        studentRepository.deleteById(id);
    }

    // LOGIN
    public Student loginStudent(String email, String password) {

        Student student = studentRepository.findByEmail(email);

        if (student != null &&
                student.getPassword().equals(password)) {

            return student;
        }

        return null;
    }
}