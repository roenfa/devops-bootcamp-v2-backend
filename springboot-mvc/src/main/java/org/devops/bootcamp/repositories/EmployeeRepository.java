package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByUserName(String userName);
}