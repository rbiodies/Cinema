package edu.school21.cinema.repositories;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ChatMessageRepositoryEntityManagerImpl implements ChatMessageRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List findTopByFilmIdOrderByTimestampDesc(Long filmId, int count) {
        return entityManager.createQuery("SELECT c FROM ChatMessage c WHERE c.film.id = ?1 ORDER BY c.id DESC")
                .setParameter(1, filmId).setMaxResults(count)
                .getResultList();
    }

    @Override
    public ChatMessage findById(long chatMessageId) {
        ChatMessage chatMessage = entityManager.find(ChatMessage.class, chatMessageId);
        if (chatMessage == null) {
            throw new EntityNotFoundException("Can't find Session for ID "
                    + chatMessageId);
        }
        return chatMessage;
    }

    @Override
    @Transactional
    public void save(ChatMessage entity) {
        entityManager.persist(entity);
    }

    @Override
    @Transactional
    public void update(ChatMessage chatMessage) {
        entityManager.merge(chatMessage);
    }

    @Override
    public List<ChatMessage> findAll() {
        return entityManager
                .createQuery("select c from ChatMessage c", ChatMessage.class).getResultList();
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
    public void delete(ChatMessage chatMessage) {
        entityManager.remove(chatMessage);
    }

    @Override
    public List search(String keyword) {
        return entityManager.createQuery("SELECT c FROM ChatMessage c WHERE c.author LIKE ?1"
                        + " OR c.content LIKE ?1")
                .setParameter(1, keyword)
                .getResultList();
    }
}
