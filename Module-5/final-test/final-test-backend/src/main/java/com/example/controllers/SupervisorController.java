package com.example.controllers;

import com.example.models.Supervisor;
import com.example.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("supervisors")
public class SupervisorController {

    @Autowired
    private SupervisorService supervisorService;

    @GetMapping("")
    public ResponseEntity<Iterable<Supervisor>> getAll() {
        if (supervisorService.getSize() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(supervisorService.findAll(), HttpStatus.OK); // 200
    }

}
