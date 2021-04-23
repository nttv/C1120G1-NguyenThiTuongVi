package com.furamavietnam.services.employee.impl;

import com.furamavietnam.models.EducationDegree;
import com.furamavietnam.repositories.employee.EducationDegreeRepository;
import com.furamavietnam.services.employee.EducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeServiceImpl implements EducationDegreeService {

    @Autowired
    private EducationDegreeRepository repository;

    @Override
    public List<EducationDegree> findAll() {
        return repository.findAll();
    }
}
