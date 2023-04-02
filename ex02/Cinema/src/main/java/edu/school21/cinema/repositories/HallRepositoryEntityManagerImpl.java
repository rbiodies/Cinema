package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Hall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class HallRepositoryEntityManagerImpl implements HallRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Hall findById(long hallId) {
        Hall hall = entityManager.find(Hall.class, hallId);
        if (hall == null) {
            throw new EntityNotFoundException("Can't find Hall for ID "
                    + hallId);
        }
        return hall;
    }

    @Override
    @Transactional
    public void save(Hall entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(Hall hall) {
        entityManager.merge(hall);
    }

    @Override
    public List<Hall> findAll() {
        return entityManager
                .createQuery("select h from Hall h", Hall.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Hall hall = entityManager.find(Hall.class, id);
        if (hall != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(Hall hall) {
        entityManager.remove(hall);
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT h FROM Hall h WHERE h.serialNumber LIKE ?1"
                        + " OR h.numberOfSeats LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }
}
