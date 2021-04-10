package com.example.services;

import com.example.models.Log;

public interface LogService {
    long getSize();

    void initialize();

    int getVisitorNumber(Integer id);

    void addVisitor(Integer id);
}
