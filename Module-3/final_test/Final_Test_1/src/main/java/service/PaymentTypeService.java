package service;

import model.PaymentType;

import java.util.List;

public interface PaymentTypeService {
    List<PaymentType> findAll();

    PaymentType findById(int id);
}
