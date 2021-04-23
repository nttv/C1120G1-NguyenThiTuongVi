package com.furamavietnam.services.service.impl;

import com.furamavietnam.models.RentType;
import com.furamavietnam.repositories.service.RentTypeRepository;
import com.furamavietnam.services.service.RentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeServiceImpl implements RentTypeService {

    @Autowired
    private RentTypeRepository repository;

    @Override
    public List<RentType> findAll() {
        return repository.findAll();
    }
}
