package com.ppt.kenzan.sample.api.employee.repositories;

import com.ppt.kenzan.sample.api.employee.model.Employee;

public interface EmployeeRepositoryCustom {

    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee, Long id);

}
