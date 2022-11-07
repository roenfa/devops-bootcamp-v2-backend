package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer> {

    //Update (User u, int id)
    @Modifying
    @Query("UPDATE User u SET u.name = ?1, u.email = ?2, u.password = ?3 WHERE u.userId = ?4")
    public User update(String name, String email, String password, int id);

    @Query("SELECT u FROM User u WHERE u.name = ?1")
    public User getByName(String name);
}
