package edu.school21.cinema.services;

import java.util.List;

public interface CrudService<T> {
    T findById(Long entityId);
    void save(T entity);
    void update(T entity);
    List<T> findAll();
    void deleteById(Long id);
    void delete(T entity);
    List<T> search(String keyword);
}
