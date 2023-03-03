package edu.school21.cinema.services;

import edu.school21.cinema.models.Film;
import edu.school21.cinema.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FilmServiceImpl implements FilmService {
    FilmRepository repo;

    @Autowired
    public FilmServiceImpl(@Qualifier("filmRepositoryEntityManagerImpl") FilmRepository repo) {
        this.repo = repo;
    }

    @Override
    public Film findById(Long filmId) {
        return repo.findById(filmId);
    }

    @Override
    public void save(Film film) {
        repo.save(film);
    }

    public void update(Film film) {
        repo.update(film);
    }

    @Override
    public List<Film> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Film film) {
        repo.delete(film);
    }

    @Override
    public List<Film> search(String keyword) {
        return repo.search(keyword);
    }

}
