package org.devops.bootcamp.controller;


import org.devops.bootcamp.models.Employee;
import org.devops.bootcamp.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/list-employees")
    public ModelAndView getAllEmployees() {
        ModelAndView mv= new ModelAndView();
        List<Employee> employees = employeeService.findAll();
        mv.addObject("employees", employees);
        mv.setViewName("list-employees");
        return mv;
    }

    @RequestMapping("/create-employee")
    public String createEmployeePage(Model model) {
        model.addAttribute("command", new Employee());
        return "create-employee";
    }

    /* Add user submitted employee info to h2 databae and redirect to list employees page. */
    @RequestMapping(value="/create-employee", method=RequestMethod.POST)
    public String createEmployee(Employee employee) {
        this.employeeService.saveEmployee(employee);
        return "redirect:/list-employees";
    }

    @RequestMapping("/update-employee/{id}")
    public String updateEmployeePage(@PathVariable("id") int id, Model model) {
        model.addAttribute("command", employeeService.findById(id).orElse(null));
        return "update-employee";
    }

    @RequestMapping(value="/update-employee", method=RequestMethod.POST)
    public String updateEmployee(Employee employee) {
        this.employeeService.updateEmployee(employee.getId(), employee);
        return "redirect:/list-employees";
    }

    @RequestMapping(value="/delete-employee/{id}", method=RequestMethod.POST)
    public String deleteEmployee(@PathVariable("id") int id) {
        this.employeeService.deleteEmployee(id);
        return "redirect:/list-employees";
    }
}