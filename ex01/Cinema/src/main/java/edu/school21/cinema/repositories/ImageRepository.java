package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;

import java.util.List;

public interface ImageRepository extends CrudRepository<Image> {

    List<Image> findAllByUserId(Long userId);
}
