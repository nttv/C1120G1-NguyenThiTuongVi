package service;

import model.Product;
import repository.ProductRepository;
import repository.ProductRepositoryImpl;

import java.sql.Date;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    ProductRepository repository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public List<Product> findTop(int top) {
        return repository.findTop(top);
    }

    @Override
    public List<Product> findInRange(Date startDate, Date endDate) {
        return repository.findInRange(startDate, endDate);
    }
}
