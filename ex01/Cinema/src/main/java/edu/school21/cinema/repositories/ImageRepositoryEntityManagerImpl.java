package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Image;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ImageRepositoryEntityManagerImpl implements ImageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Image findById(long imageId) {
        Image image = entityManager.find(Image.class, imageId);
        if (image == null) {
            throw new EntityNotFoundException("Can't find Image for ID "
                    + imageId);
        }
        return image;
    }

    @Override
    @Transactional
    public void save(Image entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(Image image) {
        entityManager.merge(image);
    }

    @Override
    public List<Image> findAll() {
        return entityManager
                .createQuery("select i from Image i", Image.class).getResultList();
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Image image = entityManager.find(Image.class, id);
        if (image != null) {
            entityManager.remove(findById(id));
        }
    }

    @Override
    @Transactional
    public void delete(Image image) {
        entityManager.remove(image);
    }

    @Override
    public List findAllByUserId(Long userId) {
        return entityManager.createQuery("SELECT image from Image image where image.user.id = ?1")
                .setParameter(1, userId)
                .getResultList();
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT i FROM Image i WHERE i.fileName LIKE ?1"
                        + " OR i.size LIKE ?1"
                        + " OR i.mime LIKE ?1"
                        + " OR i.uniqueName LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }

}
