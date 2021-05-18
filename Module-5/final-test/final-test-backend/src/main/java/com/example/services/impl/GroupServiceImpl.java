package com.example.services.impl;

import com.example.models.Group;
import com.example.repositories.GroupRepository;
import com.example.services.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupRepository groupRepository;

//    @Override
//    public List<Group> findAll() {
//        List<Group> groupList = new ArrayList<>();
//        groupRepository.findAll().forEach(groupList::add);
//        return groupList;
//    }

    @Override
    public Iterable<Group> findAll() {
        return groupRepository.findAll();
    }

    @Override
    public long getSize() {
        return groupRepository.count();
    }
}