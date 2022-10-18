package fundacionjala.backend.springdemo.repositories;

import fundacionjala.backend.springdemo.models.User;

import java.util.List;

public interface UserRepository {
    List<User> findAll();
}
