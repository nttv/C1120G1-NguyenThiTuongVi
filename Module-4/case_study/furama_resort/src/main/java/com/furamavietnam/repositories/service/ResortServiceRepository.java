package com.furamavietnam.repositories.service;

import com.furamavietnam.models.ResortService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResortServiceRepository extends JpaRepository<ResortService, String> {

    Page<ResortService> findAll(Pageable pageable);

}
