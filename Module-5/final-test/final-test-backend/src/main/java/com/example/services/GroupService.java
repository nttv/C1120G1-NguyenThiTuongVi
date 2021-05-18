package com.example.services;

import com.example.models.Group;

public interface GroupService {

    Iterable<Group> findAll();

    long getSize();

}
