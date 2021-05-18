package com.example.services;

import com.example.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findById(Integer id);

    void save(Student student);

    void delete(Integer id);

}
