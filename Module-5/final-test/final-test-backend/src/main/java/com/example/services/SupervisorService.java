package com.example.services;

import com.example.models.Supervisor;

public interface SupervisorService {

    Iterable<Supervisor> findAll();

    long getSize();

}
