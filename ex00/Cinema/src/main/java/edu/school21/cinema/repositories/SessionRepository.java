package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;

public interface SessionRepository extends CrudRepository<Session> {

    void deleteByHallId(Long id);

    void deleteByFilmId(Long id);
}
