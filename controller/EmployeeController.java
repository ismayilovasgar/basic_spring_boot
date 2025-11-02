package com.ismayilov.springboot.first_app.controller;

import com.ismayilov.springboot.first_app.entity.Employee;
//import com.ismayilov.springboot.first_app.services.EmployeeService;
import com.ismayilov.springboot.first_app.servicesJPA.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> saveEmployee() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/employees/name/{name}")
    public List<Employee> getEmployeeByName(@PathVariable String name) {
        return employeeService.findAllByName(name);
    }

    @GetMapping("/employees/{id}")
    public Employee saveEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public String deleteEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        employeeService.deleteEmployee(id);
        return "Employee wit id=" + id + " was deleted !";
    }


}
