package org.devops.bootcamp.services;

import org.devops.bootcamp.models.Employee;
import org.devops.bootcamp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> findById(int id) {
        return employeeRepository.findById((long) id);
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        Employee updatedEmployee = employeeRepository.findById(  id).orElse(null);
        assert updatedEmployee != null;
        updatedEmployee.setUserName(employee.getUserName());
        updatedEmployee.setAge(employee.getAge());
        updatedEmployee.setSalary(employee.getSalary());
        updatedEmployee.setEmail(employee.getEmail());
        updatedEmployee.setGender(employee.getGender());
        return employeeRepository.save(updatedEmployee);
    }

    public String deleteEmployee(int id) {
        employeeRepository.deleteById((long) id);
        return "Employee removed !! " + id;
    }
}
