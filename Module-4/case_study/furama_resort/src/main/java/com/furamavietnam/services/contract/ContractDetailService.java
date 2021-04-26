package com.furamavietnam.services.contract;

import com.furamavietnam.models.ContractDetail;

public interface ContractDetailService {

    ContractDetail findById(Integer id);

    void save(ContractDetail contractDetail);

    void delete(Integer id);

}
