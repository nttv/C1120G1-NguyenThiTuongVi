package service;

import model.User;
import repository.UserRepository;
import repository.UserRepositoryImpl;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository repository = new UserRepositoryImpl();

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }

    @Override
    public User findById(int id) {
        return repository.findById(id);
    }

    @Override
    public void save(User user) {
        repository.save(user);
    }

    @Override
    public void update(User user) {
        repository.update(user);
    }

    @Override
    public void remove(int id) {
        repository.remove(id);
    }

    @Override
    public List<User> findByCountry(String country) {
        return repository.findByCountry(country);
    }
}
