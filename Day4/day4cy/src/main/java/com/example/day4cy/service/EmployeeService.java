package com.example.day4cy.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.day4cy.model.Employee;
import com.example.day4cy.repository.EmployeeRepo;

@Service
public class EmployeeService {
    public EmployeeRepo employeeRepo;
    public EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo=employeeRepo;
    }
    public boolean saveEmployee(Employee employee)
    {
        try{
            employeeRepo.save(employee);

        }
        catch(Exception e)
        {
            return false;
        }
        return true;
    }
    public List<Employee> getEmployees()
    {
        return employeeRepo.findAll();
    }
    public Employee getEmployeeById(int id)
    {
        Optional<Employee> obj = employeeRepo.findById(id);
        return obj.orElse(null);
    }
}
