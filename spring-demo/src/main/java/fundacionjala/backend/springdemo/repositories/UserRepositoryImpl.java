package fundacionjala.backend.springdemo.repositories;

import fundacionjala.backend.springdemo.models.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        users.add(new User("Juan", "Vasquez"));
        users.add(new User("Maria", "Lopez"));

        return this.users;
    }
}
