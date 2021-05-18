package com.example.services.impl;

import com.example.models.Student;
import com.example.repositories.StudentRepository;
import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(Integer id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }
}
