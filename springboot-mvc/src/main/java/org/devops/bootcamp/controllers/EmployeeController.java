package org.devops.bootcamp.controllers;


import org.devops.bootcamp.constants.ConstantVariable;
import org.devops.bootcamp.models.Employee;
import org.devops.bootcamp.repositories.EmployeeRepository;
import org.devops.bootcamp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /* List added employees. */
    @RequestMapping(value="/listEmployee", method= RequestMethod.GET)
    public String listEmployeeList(Model model) {
        List<Employee> employeeList = this.employeeService.findAll();

        model.addAttribute(ConstantVariable.EMPLOYEE_LIST, employeeList);

        return "listEmployee";
    }

    /* Display add employee form page. */
    @RequestMapping(value="/addEmployeePage", method=RequestMethod.GET)
    public String addEmployeePage() {
        return "addEmployee";
    }

    /* Add user submitted employee info to h2 databae and redirect to list employees page. */
    @RequestMapping(value ="/addEmployee", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.save(employee);
        return "redirect:/employee/listEmployee";
    }
}