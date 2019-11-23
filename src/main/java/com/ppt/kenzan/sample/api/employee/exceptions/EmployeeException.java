package com.ppt.kenzan.sample.api.employee.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Custom exception when a not found API error occurs, usually on a PUT or DELETE.
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmployeeException extends RuntimeException {

    public EmployeeException(String exception) {
        super(exception);
    }
}
