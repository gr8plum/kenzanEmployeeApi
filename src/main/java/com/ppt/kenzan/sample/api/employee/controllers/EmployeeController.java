package com.ppt.kenzan.sample.api.employee.controllers;

import com.ppt.kenzan.sample.api.employee.exceptions.EmployeeException;
import com.ppt.kenzan.sample.api.employee.model.Employee;
import com.ppt.kenzan.sample.api.employee.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Employee API
 *    GET:    /employees - retrieves all employees that have a status of true (employed) (requires authorization header)
 *    POST:   /employees - adds an employee using supplied request body and authorization header
 *    PUT:    /employees/{id} updates an employee using supplied request body and authorization header
 *    DELETE: /employees/{id} updates an employee using supplied request body and authorization header setting status to false
 *
 *    GET:   /employees/validate retrieves all employees for a complete view of the data
 */

@RestController
@RequestMapping(path="/")
public class EmployeeController {


    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(path="/employees/validate")
    Iterable <Employee> getForValidate() {
        return employeeRepository.findAll();
    }

    @GetMapping(path="/employees")
    Iterable <Employee> getAllEmployees() {
        return employeeRepository.findAllEmployees();
    }

    @GetMapping(path="/employees/{id}")
    Employee getEmployee(@PathVariable("id") Long id) {
        System.out.println("in getEmployee controller - find Employee: " + id);
        return employeeRepository.findEmployee(id).get();
    }

    @PostMapping(path="/employees/")
    public @ResponseBody
    void addEmployee(@RequestBody Employee employee) {
                System.out.println("in addEmployee controller - Employee: " + employee.toString());
        employeeRepository.insertEmployee(employee);
    }

   @PutMapping(path="/employees/{id}")
   public @ResponseBody

    void updateEmployee(@RequestBody Employee employee, @PathVariable("id") Long id ) {
       Optional<Employee> employeeCheck = employeeRepository.findEmployee(id);
       if (!employeeCheck.isPresent()) {
           throw new EmployeeException("Employee not found with ID  = " + id );
       }
        employeeRepository.updateEmployee(employee, id);
    }

   @DeleteMapping(path="/employees/{id}")
   void deleteEmployee(@PathVariable("id") Long id ) {
       Optional<Employee> employee = employeeRepository.findEmployee(id);
       if (!employee.isPresent()) {
           throw new EmployeeException("Employee not found with ID  = " + id );
       }
       employeeRepository.deleteEmployee(id);

   }

}
