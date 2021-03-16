package repository;

import model.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();

    User findById(int id);

    void save(User user);

    void update(User user);

    void remove(int id);
}
