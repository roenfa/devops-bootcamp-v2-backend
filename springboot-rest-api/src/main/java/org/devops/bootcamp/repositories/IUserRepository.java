package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    public User getUserByUsername(@Param("username") String username);
}
