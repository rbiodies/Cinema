package edu.school21.cinema.services;

import edu.school21.cinema.models.User;

public interface UserService extends CrudService<User> {

    User findByEmailAndPassword(String email, String password);
}
