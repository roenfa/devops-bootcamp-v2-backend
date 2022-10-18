package fundacionjala.backend.springdemo.services;

import fundacionjala.backend.springdemo.models.User;
import fundacionjala.backend.springdemo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    private UserRepository repo;

    @Autowired
    public void setRepo(UserRepository repository) {
        this.repo = repository;
    }

    @Override
    public List<User> findAll() {
        return this.repo.findAll();
    }
}
