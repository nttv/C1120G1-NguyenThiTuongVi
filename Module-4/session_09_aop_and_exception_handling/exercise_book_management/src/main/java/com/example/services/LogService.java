package com.example.services;

import com.example.models.Log;

public interface LogService {
    int getSize();

    void save(Log log);

    int getVisitorNumber(Integer id);

    void addVisitor(Integer id);
}
