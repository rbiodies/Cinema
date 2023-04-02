package edu.school21.cinema.repositories;

import java.util.List;

public interface CrudRepository<T> {
    T findById(long entityId);
    void save(T entity);
    void update(T entity);
    List<T> findAll();
    void deleteById(Long id);
    void delete(T entity);
    List<T> search(String keyword);
}
