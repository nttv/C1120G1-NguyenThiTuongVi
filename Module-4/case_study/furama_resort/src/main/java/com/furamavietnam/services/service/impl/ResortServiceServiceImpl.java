package com.furamavietnam.services.service.impl;

import com.furamavietnam.models.Customer;
import com.furamavietnam.models.ResortService;
import com.furamavietnam.repositories.service.ResortServiceRepository;
import com.furamavietnam.services.service.ResortServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;

import java.util.List;

@Service
public class ResortServiceServiceImpl implements ResortServiceService {

    @Autowired
    private ResortServiceRepository repository;

    @Override
    public Page<ResortService> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public List<ResortService> findAll() {
        return repository.findAll();
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

    @Override
    public void validateExistingId(ResortService resortService, Errors errors) {
        ResortService service = findById(resortService.getServiceId());
        if (service != null) {
            errors.rejectValue("serviceId", "duplicate.service.id");
        }
    }

}
