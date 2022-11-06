package org.devops.bootcamp.repositories;


import org.springframework.stereotype.Repository;
import org.devops.bootcamp.models.DAOUser;
import org.springframework.data.repository.CrudRepository;


@Repository
public interface UserDAO extends CrudRepository<DAOUser, Long> {
    DAOUser findByUsername(String username);
}