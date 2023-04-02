package edu.school21.cinema.services;

import edu.school21.cinema.models.ChatMessage;
import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.ChatMessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ChatMessageServiceImpl implements ChatMessageService {
    ChatMessageRepository repo;

    @Autowired
    public ChatMessageServiceImpl(@Qualifier("chatMessageRepositoryEntityManagerImpl") ChatMessageRepository repo) {
        this.repo = repo;
    }

    @Override
    public ChatMessage findById(Long chatMessageId) {
        return repo.findById(chatMessageId);
    }

    @Override
    public void save(ChatMessage chatMessage) {
        repo.save(chatMessage);
    }

    public void update(ChatMessage chatMessage) {
        repo.update(chatMessage);
    }

    @Override
    public List<ChatMessage> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(ChatMessage chatMessage) {
        repo.delete(chatMessage);
    }

    @Override
    public List<ChatMessage> search(String keyword) {
        return repo.search(keyword);
    }

    @Override
    public List<ChatMessage> findTopByFilmIdOrderByTimestampDesc(Long filmId, int count) {
        return repo.findTopByFilmIdOrderByTimestampDesc(filmId, count);
    }
}
