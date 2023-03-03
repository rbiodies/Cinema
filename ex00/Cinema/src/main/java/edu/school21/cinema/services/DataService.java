package edu.school21.cinema.services;

import edu.school21.cinema.models.Data;

import java.util.List;

public interface DataService extends CrudService<Data> {

    List<Data> findAllByUserId(Long userId);
}
