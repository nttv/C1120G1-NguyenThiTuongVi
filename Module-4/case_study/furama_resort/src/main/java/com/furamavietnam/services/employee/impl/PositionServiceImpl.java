package com.furamavietnam.services.employee.impl;

import com.furamavietnam.models.Position;
import com.furamavietnam.repositories.employee.PositionRepository;
import com.furamavietnam.services.employee.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }

}
