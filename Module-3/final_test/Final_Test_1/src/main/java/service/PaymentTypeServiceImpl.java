package service;

import model.PaymentType;
import repository.PaymentTypeRepository;
import repository.PaymentTypeRepositoryImpl;
import service.PaymentTypeService;

import java.util.List;

public class PaymentTypeServiceImpl implements PaymentTypeService {
    private PaymentTypeRepository repository = new PaymentTypeRepositoryImpl();

    @Override
    public List<PaymentType> findAll() {
        return repository.findAll();
    }

    @Override
    public PaymentType findById(int id) {
        return repository.findById(id);
    }
}
