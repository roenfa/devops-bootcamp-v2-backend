package org.devops.bootcamp.services;

import org.devops.bootcamp.models.Employee;
import org.devops.bootcamp.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    public List<Employee> findAllEmployees(){
        return this.employeeRepository.findAll();
    }

    public void deleteEmployee(Employee employee){
        this.employeeRepository.delete(employee);
    }

    public void deleteEmployeeById(Long id){
        this.employeeRepository.deleteById(id);
    }

    public Employee updateEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

}
