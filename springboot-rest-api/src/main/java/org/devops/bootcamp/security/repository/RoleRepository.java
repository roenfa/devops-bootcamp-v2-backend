package org.devops.bootcamp.security.repository;


import org.devops.bootcamp.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, String>{
}
