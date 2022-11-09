package org.devops.bootcamp.repositories;

import org.devops.bootcamp.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    /* We add a custom method here but do not use it in this example.
     * The method name must follow findBy<column name> pattern, then JpaRepository
     * will implement the detailed JDBC query code which we do not need to care about, we just
     * need to call this method and pass in the userName to get the result list.
     * */
    List<Employee> findByUserName(String userName);
}