package edu.school21.cinema.services;

import edu.school21.cinema.models.Image;

import java.util.List;

public interface ImageService extends CrudService<Image> {

    List<Image> findAllByUserId(Long userId);
}
