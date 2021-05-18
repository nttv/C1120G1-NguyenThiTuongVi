package com.example.services.impl;

import com.example.models.Supervisor;
import com.example.repositories.SupervisorRepository;
import com.example.services.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupervisorServiceImpl implements SupervisorService {

    @Autowired
    private SupervisorRepository supervisorRepository;

    @Override
    public Iterable<Supervisor> findAll() {
        return supervisorRepository.findAll();
    }

    @Override
    public long getSize() {
        return supervisorRepository.count();
    }
}
