package com.furamavietnam.services.service.impl;

import com.furamavietnam.models.ServiceType;
import com.furamavietnam.repositories.service.ServiceTypeRepository;
import com.furamavietnam.services.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository repository;

    @Override
    public List<ServiceType> findAll() {
        return repository.findAll();
    }
}
