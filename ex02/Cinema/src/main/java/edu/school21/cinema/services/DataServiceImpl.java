package edu.school21.cinema.services;

import edu.school21.cinema.models.Data;
import edu.school21.cinema.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DataServiceImpl implements DataService {
    DataRepository repo;

    @Autowired
    public DataServiceImpl(@Qualifier("dataRepositoryEntityManagerImpl") DataRepository repo) {
        this.repo = repo;
    }

    @Override
    public Data findById(Long dataId) {
        return repo.findById(dataId);
    }

    @Override
    public void save(Data data) {
        repo.save(data);
    }

    public void update(Data data) {
        repo.update(data);
    }

    @Override
    public List<Data> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(Data data) {
        repo.delete(data);
    }

    @Override
    public List<Data> search(String keyword) {
        return repo.search(keyword);
    }

    @Override
    public List<Data> findAllByUserId(Long userId) {
        return repo.findAllByUserId(userId);
    }

}
