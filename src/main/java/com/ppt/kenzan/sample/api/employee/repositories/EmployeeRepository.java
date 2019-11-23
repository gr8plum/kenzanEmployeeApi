package com.ppt.kenzan.sample.api.employee.repositories;

import com.ppt.kenzan.sample.api.employee.model.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends CrudRepository<Employee, Long>, EmployeeRepositoryCustom {

    @Transactional
    @Modifying
    @Query(value="UPDATE employee set status = 0 where id = :id", nativeQuery = true)
    void deleteEmployee(@Param("id") Long id);

    @Query(value="SELECT id, first_name, middle_name, last_name, date_of_birth, date_of_employment, status FROM employee WHERE status = 1", nativeQuery = true)
    List<Employee> findAllEmployees();

    @Query(value="SELECT * FROM employee WHERE status = 1 AND id = :id", nativeQuery = true)
    Optional<Employee> findEmployee(@Param("id") Long id);



}
