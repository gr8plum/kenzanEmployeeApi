package com.ppt.kenzan.sample.api.employee.model;


import lombok.Data;
import org.hibernate.exception.DataException;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Comparator;
import java.util.Date;

@Data
@Entity
@Table(name = "employee")
public class Employee {

    @Column(name="id", nullable=false)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="middle_name", nullable=true)
    private String middleName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="date_of_birth", nullable=false)
    private Date dateOfBirth;

    @Column(name="date_of_employment", nullable=false)
    private Date dateOfEmployment;

    /* The status is defaulted by the database */
    @Column(name="status", columnDefinition = "boolean default true")
    private Boolean status;

    /* ******************************************************************************
    * Allows a collection of employees to be sorted by last name
    ********************************************************************************/
public static Comparator<Employee> sortByLastName = new Comparator<Employee>() {
    @Override
    public int compare(Employee e1, Employee e2) {
        return e1.lastName.compareTo(e2.lastName);
    }
};

    /* ******************************************************************************
     * Allows a collection of employees to be sorted by date of employement
     ********************************************************************************/
    public static Comparator<Employee> sortByDateOfEmployment = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.dateOfEmployment.compareTo(e2.dateOfEmployment);
        }
    };

}
