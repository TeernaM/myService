package com.example.myService.exceptions;

import com.example.myService.entity.CodeResponse;
import org.hibernate.PersistentObjectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class EmployeeExceptions extends ResponseEntityExceptionHandler{

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<CodeResponse> handleNoSuchElementExceptions(Exception exception){

        return new ResponseEntity<>(new CodeResponse("1404", "Employee not found"), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(PersistentObjectException.class)
    public ResponseEntity<CodeResponse> handlePersistentObjectException(Exception exception){

        return new ResponseEntity<>(new CodeResponse("1405", "Request contains duplicate employee id"), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CodeResponse> handleValidationExceptions(ValidationException exception){

        return new ResponseEntity<>(new CodeResponse(exception.getCode(), exception.getMessage()), HttpStatus.BAD_REQUEST);
    }

}
