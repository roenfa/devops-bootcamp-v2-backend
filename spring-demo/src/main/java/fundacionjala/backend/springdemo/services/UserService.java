package fundacionjala.backend.springdemo.services;

import fundacionjala.backend.springdemo.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
}
