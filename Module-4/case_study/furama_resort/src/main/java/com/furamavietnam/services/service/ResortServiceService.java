package com.furamavietnam.services.service;

import com.furamavietnam.models.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.Errors;

import java.util.List;

public interface ResortServiceService {

    Page<ResortService> findAll(Pageable pageable);

    List<ResortService> findAll();

    ResortService findById(String id);

    void save(ResortService resortService);

    void delete(String id);

    void validateExistingId(ResortService resortService, Errors errors);

}
