package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Data;

import java.util.List;

public interface DataRepository extends CrudRepository<Data> {

    List<Data> findAllByUserId(Long userId);
}
