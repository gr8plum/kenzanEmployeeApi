package com.ppt.kenzan.sample.api.employee.repositories;

import com.ppt.kenzan.sample.api.employee.model.Employee;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigInteger;
import java.util.List;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;


    @Override
    @Transactional
    public void insertEmployee(Employee employee) {

        System.out.println("in insertEmployee repository - Employee: " + employee.toString());


      entityManager.createNativeQuery("INSERT INTO employee (first_name, middle_name, last_name, date_of_birth, date_of_employment, status) VALUES (?,?,?,?,?,?)")
                .setParameter(1, employee.getFirstName())
                .setParameter(2, employee.getMiddleName())
                .setParameter(3, employee.getLastName())
                .setParameter(4, employee.getDateOfBirth())
                .setParameter(5, employee.getDateOfEmployment())
                .setParameter(6, 1)
               .executeUpdate();

    }

    @Override
    @Transactional
    public void updateEmployee(Employee employee, Long idIn) {

        entityManager.createNativeQuery("UPDATE employee SET first_name = ?, middle_name = ? , last_name = ?, date_of_birth = ?, date_of_employment = ? WHERE id = ?")
                .setParameter(1, employee.getFirstName())
                .setParameter(2, employee.getMiddleName())
                .setParameter(3, employee.getLastName())
                .setParameter(4, employee.getDateOfBirth())
                .setParameter(5, employee.getDateOfEmployment())
                .setParameter(6, idIn)
                .executeUpdate();




    }

}
