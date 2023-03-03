package edu.school21.cinema.services;

import edu.school21.cinema.models.Session;
import edu.school21.cinema.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SessionServiceImpl implements SessionService {
    SessionRepository repo;

    @Autowired
    public SessionServiceImpl(@Qualifier("sessionRepositoryEntityManagerImpl") SessionRepository repo) {
        this.repo = repo;
    }

    @Override
    public Session findById(Long sessionId) {
        return repo.findById(sessionId);
    }

    @Override
    public void save(Session session) {
        repo.save(session);
    }

    public void update(Session session) {
        repo.update(session);
    }

    @Override
    public List<Session> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Session session) {
        repo.delete(session);
    }

    @Override
    public List<Session> search(String keyword) {
        return repo.search(keyword);
    }

}
