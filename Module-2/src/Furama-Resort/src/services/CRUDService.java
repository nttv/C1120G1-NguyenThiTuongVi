package services;

import java.util.List;

public interface CRUDService<T> {
    List<T> findAll();
    T findById(String id);
    void add(T t);
    void edit(T t, String id);
    void remove(String id);
}
