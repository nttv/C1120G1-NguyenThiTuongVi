package com.furamavietnam.services.customer.impl;

import com.furamavietnam.models.CustomerType;
import com.furamavietnam.repositories.customer.CustomerTypeRepository;
import com.furamavietnam.services.customer.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository repository;

    @Override
    public List<CustomerType> findAll() {
        return repository.findAll();
    }
}
