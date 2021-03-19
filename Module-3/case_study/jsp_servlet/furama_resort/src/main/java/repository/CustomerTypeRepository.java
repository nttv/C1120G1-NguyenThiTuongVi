package repository;

import model.CustomerType;

public interface CustomerTypeRepository {
    CustomerType findById(int id);
}
