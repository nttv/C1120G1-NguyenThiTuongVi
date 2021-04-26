package com.furamavietnam.services.contract.impl;

import com.furamavietnam.models.Contract;
import com.furamavietnam.models.ContractDetail;
import com.furamavietnam.repositories.contract.ContractRepository;
import com.furamavietnam.services.contract.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public Page<Contract> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Contract findById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void save(Contract contract) {
        contract.setContractTotalMoney(getTotalAmount(contract));
        repository.save(contract);
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public double getTotalAmount(Contract contract) {
        long days = 0;
        double totalAmount = contract.getResortService().getRentType().getRentTypeCost();
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractStartDate());
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(contract.getContractEndDate());
            days = TimeUnit.DAYS.convert(endDate.getTime() - startDate.getTime(), TimeUnit.MILLISECONDS);
            if (days == 0) {
                days = 1;
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        totalAmount += Double.parseDouble(contract.getResortService().getServiceCost()) * days;
        Set<ContractDetail> details = contract.getContractDetails();
        if (details != null && !details.isEmpty()) {
            for (ContractDetail detail : details) {
                totalAmount += detail.getAttachService().getAttachServiceCost() * detail.getQuantity();
            }
        }
        return totalAmount;
    }
}
