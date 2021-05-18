package com.example.controllers;

import com.example.models.Group;
import com.example.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("groups")
public class GroupController {

    @Autowired
    private GroupService groupService;

    @GetMapping("")
    public ResponseEntity<Iterable<Group>> getAll() {
        if (groupService.getSize() == 0) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(groupService.findAll(), HttpStatus.OK); // 200
    }

//    @GetMapping("")
//    public ResponseEntity<List<Group>> getAll() {
//        List<Group> groupList = groupService.findAll();
//        if (groupList.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
//        }
//        return new ResponseEntity<>(groupList, HttpStatus.OK); // 200
//    }

}
