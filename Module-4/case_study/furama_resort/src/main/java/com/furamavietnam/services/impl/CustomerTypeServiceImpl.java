package com.furamavietnam.services.impl;

import com.furamavietnam.models.CustomerType;
import com.furamavietnam.repositories.CustomerTypeRepository;
import com.furamavietnam.services.CustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeServiceImpl implements CustomerTypeService {

    @Autowired
    private CustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> findAll() {
        return customerTypeRepository.findAll();
    }
}
