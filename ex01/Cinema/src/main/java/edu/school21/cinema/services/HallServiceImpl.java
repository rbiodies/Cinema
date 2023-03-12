package edu.school21.cinema.services;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HallServiceImpl implements HallService {
    HallRepository repo;

    @Autowired
    public HallServiceImpl(@Qualifier("hallRepositoryEntityManagerImpl") HallRepository repo) {
        this.repo = repo;
    }

    @Override
    public Hall findById(Long hallId) {
        return repo.findById(hallId);
    }

    @Override
    public void save(Hall hall) {
        repo.save(hall);
    }

    public void update(Hall hall) {
        repo.update(hall);
    }

    @Override
    public List<Hall> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Hall hall) {
        repo.delete(hall);
    }

    @Override
    public List<Hall> search(String keyword) {
        return repo.search(keyword);
    }

}
