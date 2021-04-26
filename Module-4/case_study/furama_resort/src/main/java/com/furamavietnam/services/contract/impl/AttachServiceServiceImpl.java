package com.furamavietnam.services.contract.impl;

import com.furamavietnam.models.AttachService;
import com.furamavietnam.repositories.contract.AttachServiceRepository;
import com.furamavietnam.services.contract.AttachServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceServiceImpl implements AttachServiceService {

    @Autowired
    private AttachServiceRepository repository;

    @Override
    public List<AttachService> findAll() {
        return repository.findAll();
    }
}
