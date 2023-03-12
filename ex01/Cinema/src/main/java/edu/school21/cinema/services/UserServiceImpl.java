package edu.school21.cinema.services;

import edu.school21.cinema.models.User;
import edu.school21.cinema.models.User;
import edu.school21.cinema.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    UserRepository repo;
    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    @Autowired
    public UserServiceImpl(@Qualifier("userRepositoryEntityManagerImpl") UserRepository repo) {
        this.repo = repo;
    }

    @Override
    public User findById(Long userId) {
        return repo.findById(userId);
    }

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    public void update(User user) {
        repo.update(user);
    }

    @Override
    public List<User> findAll() {
        return repo.findAll();
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void delete(User user) {
        repo.delete(user);
    }

    @Override
    public List<User> search(String keyword) {
        return repo.search(keyword);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        User user = repo.findByEmail(email);
        if (user != null) {
            if (bCryptPasswordEncoder.matches(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }
}
