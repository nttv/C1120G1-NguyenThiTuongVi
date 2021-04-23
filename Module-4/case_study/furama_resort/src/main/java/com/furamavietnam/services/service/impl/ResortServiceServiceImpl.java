package com.furamavietnam.services.service.impl;

import com.furamavietnam.models.ResortService;
import com.furamavietnam.repositories.service.ResortServiceRepository;
import com.furamavietnam.services.service.ResortServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ResortServiceServiceImpl implements ResortServiceService {

    @Autowired
    private ResortServiceRepository repository;

    @Override
    public Page<ResortService> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public ResortService findById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(ResortService resortService) {
        repository.save(resortService);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }

}
