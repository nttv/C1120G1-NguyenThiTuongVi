package service;

import model.Product;

import java.sql.Date;
import java.util.List;

public interface ProductService {
    List<Product> findAll();

    void save(Product product);

    List<Product> findTop(int top);

    List<Product> findInRange(Date startDate, Date endDate);
}
