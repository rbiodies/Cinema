package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;

public interface UserRepository extends CrudRepository<User> {

    User findByEmail(String email);
}
