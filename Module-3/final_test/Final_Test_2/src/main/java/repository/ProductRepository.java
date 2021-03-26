package repository;

import model.Product;

import java.sql.Date;
import java.util.List;

public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    List<Product> findTop(int top);

    List<Product> findInRange(Date startDate, Date endDate);
}
