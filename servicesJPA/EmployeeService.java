package com.ismayilov.springboot.first_app.servicesJPA;

import com.ismayilov.springboot.first_app.entity.Employee;

import java.util.List;


public interface EmployeeService {
    List<Employee> getAllEmployees();

    void saveEmployee(Employee employee);

    Employee getEmployee(int id);

    void deleteEmployee(int id);

    List<Employee> findAllByName(String name);

}
