package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SessionRepositoryEntityManagerImpl implements SessionRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Session findById(long sessionId) {
        Session session = entityManager.find(Session.class, sessionId);
        if (session == null) {
            throw new EntityNotFoundException("Can't find Session for ID "
                    + sessionId);
        }
        return session;
    }

    @Override
    @Transactional
    public void save(Session entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(Session session) {
        entityManager.merge(session);
    }

    @Override
    public List<Session> findAll() {
        return entityManager
                .createQuery("select s from Session s", Session.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Session session = entityManager.find(Session.class, id);
        if (session != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(Session session) {
        entityManager.remove(session);
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT s FROM Session s WHERE s.time LIKE ?1"
                        + " OR s.ticketCost LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }

    @Override
    @Transactional
    public void deleteByHallId(Long id) {
        entityManager.createQuery("delete from Session where hall.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    @Transactional
    public void deleteByFilmId(Long id) {
        entityManager.createQuery("delete from Session where film.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public List findByFilmName(String filmName) {
        return entityManager.createQuery("SELECT s FROM Session s WHERE s.film.title LIKE ?1")
                .setParameter(1, filmName)
                .getResultList();
    }
}
