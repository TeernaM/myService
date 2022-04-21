package com.example.myService.service;

import com.example.myService.entity.Employee;
import com.example.myService.exceptions.ValidationException;
import com.example.myService.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return  employeeRepository.findAll();
    }

    public Employee getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        return employee.get();
    }

    public Employee addEmployee(Employee employee) {

        if(employee.getFirstName().isEmpty() || employee.getFirstName() == null || employee.getLastName().isEmpty() || employee.getLastName() == null)
            throw new ValidationException("1400", "Employee name is empty or null");

        return employeeRepository.save(employee);

    }
}
