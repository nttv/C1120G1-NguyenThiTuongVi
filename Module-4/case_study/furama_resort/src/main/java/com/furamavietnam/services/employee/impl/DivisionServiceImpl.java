package com.furamavietnam.services.employee.impl;

import com.furamavietnam.models.Division;
import com.furamavietnam.repositories.employee.DivisionRepository;
import com.furamavietnam.services.employee.DivisionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements DivisionService {

    @Autowired
    private DivisionRepository repository;

    @Override
    public List<Division> findAll() {
        return repository.findAll();
    }
}
