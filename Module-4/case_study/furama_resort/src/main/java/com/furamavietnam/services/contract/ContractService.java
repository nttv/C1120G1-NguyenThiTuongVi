package com.furamavietnam.services.contract;

import com.furamavietnam.models.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ContractService {

    Page<Contract> findAll(Pageable pageable);

    Contract findById(Integer id);

    void save(Contract contract);

    void delete(Integer id);

    double getTotalAmount(Contract contract);

}
