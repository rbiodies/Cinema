package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DataRepositoryEntityManagerImpl implements DataRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Data findById(long dataId) {
        Data data = entityManager.find(Data.class, dataId);
        if (data == null) {
            throw new EntityNotFoundException("Can't find Data for ID "
                    + dataId);
        }
        return data;
    }

    @Override
    @Transactional
    public void save(Data entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(Data data) {
        entityManager.merge(data);
    }

    @Override
    public List<Data> findAll() {
        return entityManager
                .createQuery("select d from Data d", Data.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Data data = entityManager.find(Data.class, id);
        if (data != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(Data data) {
        entityManager.remove(data);
    }

    @Override
    public List findAllByUserId(Long userId) {
        return entityManager.createQuery("SELECT data from Data data where data.user.id = ?1")
                .setParameter(1, userId)
                .getResultList();
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT d FROM Data d WHERE d.date LIKE ?1"
                        + " OR d.time LIKE ?1"
                        + " OR d.ip LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }
}
