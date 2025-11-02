package com.ismayilov.springboot.first_app.dao;

import com.ismayilov.springboot.first_app.entity.Employee;
//* Hibernate ---------------------
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//*--------------------------------
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        //* Hibernate
        // Session session = entityManager.unwrap(Session.class);
        // return session.createQuery("from Employee", Employee.class).getResultList();

        //* JPA
        Query query = entityManager.createQuery("from Employee ");
        List<Employee> allEmployees = query.getResultList();
        return allEmployees;
    }


    @Override
    public void saveEmployee(Employee employee) {
        //* Hibernate
        // Session session = entityManager.unwrap(Session.class);
        // session.saveOrUpdate(employee);

        //* JPA
        Employee newEmployee = entityManager.merge(employee);
        employee.setId(newEmployee.getId());
    }

    @Override
    public Employee getEmployee(int id) {
        //* Hibernate
        // Session session = entityManager.unwrap(Session.class);
        // return session.get(Employee.class, id);

        //* JPA
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        //* Hibernate
        // Session session = entityManager.unwrap(Session.class);
        // Query<Employee> query = session.createQuery("delete from Employee where id=:employeeId");
        // query.setParameter("employeeId", id);
        // query.executeUpdate();

        //* JPA
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }

}
