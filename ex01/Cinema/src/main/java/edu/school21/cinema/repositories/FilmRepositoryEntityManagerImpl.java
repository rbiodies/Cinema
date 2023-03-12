package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Film;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class FilmRepositoryEntityManagerImpl implements FilmRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Film findById(long filmId) {
        Film film = entityManager.find(Film.class, filmId);
        if (film == null) {
            throw new EntityNotFoundException("Can't find Film for ID "
                    + filmId);
        }
        return film;
    }

    @Override
    @Transactional
    public void save(Film entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(Film film) {
        entityManager.merge(film);
    }

    @Override
    public List<Film> findAll() {
        return entityManager
                .createQuery("select f from Film f", Film.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Film film = entityManager.find(Film.class, id);
        if (film != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(Film film) {
        entityManager.remove(film);
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT f FROM Film f WHERE f.title LIKE ?1"
                        + " OR f.yearOfRelease LIKE ?1"
                        + " OR f.ageRestrictions LIKE ?1"
                        + " OR f.description LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }
}
