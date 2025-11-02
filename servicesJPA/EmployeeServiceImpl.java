package com.ismayilov.springboot.first_app.servicesJPA;

import com.ismayilov.springboot.first_app.dao.EmployeeDAO;
import com.ismayilov.springboot.first_app.entity.Employee;
import com.ismayilov.springboot.first_app.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service("employeeServiceJPA")
@Primary
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveEmployee(Employee employee) {
        // employeeDAO.saveEmployee(employee);
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(int id) {
        // return employeeDAO.getEmployee(id);
        Employee employee = null;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent())
            employee = optionalEmployee.get();
        return employee;
    }

    @Override
    public void deleteEmployee(int id) {
        //employeeDAO.deleteEmployee(id);
        employeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByName(String name) {
        return employeeRepository.findByName(name);
    }


}
