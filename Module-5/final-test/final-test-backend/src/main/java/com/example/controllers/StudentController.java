package com.example.controllers;

import com.example.models.Student;
import com.example.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("")
    public ResponseEntity<List<Student>> getAll() {
        List<Student> studentList = studentService.findAll();
        if (studentList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(studentList, HttpStatus.OK); //200
    }

    @GetMapping("{id}")
    public ResponseEntity<Student> getById(@PathVariable("id") Integer id) {
        Student student = studentService.findById(id);
        if (student == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        return new ResponseEntity<>(student, HttpStatus.OK); //200
    }

    @PostMapping("")
    public ResponseEntity<Void> save(@RequestBody Student student) {
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.CREATED); // 201
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Integer id, @RequestBody Student student) {
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        student.setStudentId(id);
        studentService.save(student);
        return new ResponseEntity<>(HttpStatus.OK); // 200
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        Student currentStudent = studentService.findById(id);
        if (currentStudent == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404
        }
        studentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK); // 200
    }

}
