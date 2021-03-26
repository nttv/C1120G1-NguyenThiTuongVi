package repository;

import model.PaymentType;

import java.util.List;

public interface PaymentTypeRepository {
    List<PaymentType> findAll();

    PaymentType findById(int id);
}
