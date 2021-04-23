package com.furamavietnam.services.service;

import com.furamavietnam.models.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ResortServiceService {

    Page<ResortService> findAll(Pageable pageable);

    ResortService findById(String id);

    void save(ResortService resortService);

    void delete(String id);

}
