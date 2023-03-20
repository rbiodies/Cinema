package edu.school21.cinema.repositories;

import edu.school21.cinema.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserRepositoryEntityManagerImpl implements UserRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public User findById(long userId) {
        User user = entityManager.find(User.class, userId);
        if (user == null) {
            throw new EntityNotFoundException("Can't find User for ID "
                    + userId);
        }
        return user;
    }

    @Override
    @Transactional
    public void save(User entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public List<User> findAll() {
        return entityManager
                .createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        User user = entityManager.find(User.class, id);
        if (user != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(User user) {
        entityManager.remove(user);
    }

    @Override
    public User findByEmail(String email) {
        try {
            return (User) entityManager.createQuery("SELECT user from User user where user.email = ?1").setParameter(1, email).getSingleResult();
        } catch (NoResultException nre) {
            return null;
        }
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT u FROM User u WHERE u.firstName LIKE ?1"
                        + " OR u.lastName LIKE ?1"
                        + " OR u.phoneNumber LIKE ?1"
                        + " OR u.email LIKE ?1"
                        + " OR u.password LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }
}
