package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;

import java.util.List;

public interface SessionService extends CrudService<Session> {

    void deleteByHallId(Long id);

    void deleteByFilmId(Long id);

    List<Session> findByFilmName(String filmName);
}
