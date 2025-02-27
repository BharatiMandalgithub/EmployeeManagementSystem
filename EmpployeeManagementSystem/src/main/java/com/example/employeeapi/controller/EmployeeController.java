package com.example.employeeapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.*;
import com.example.employeeapi.entity.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private Map<Long, Employee> employeeEntry = new HashMap<>();

    // Retrieve all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeEntry.values());
    }

    // Create a new employee
    @PostMapping
    public boolean createEmployee(@RequestBody Employee employee) {
        employeeEntry.put(employee.getId(), employee);
        return true;
    }

    // Retrieve an employee by ID
    @GetMapping("/id/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeEntry.get(id);
    }

    // Delete an employee by ID
    @DeleteMapping("/id/{id}")
    public Employee deleteEmployeeById(@PathVariable Long id) {
        return employeeEntry.remove(id);
    }

    // Update an employee by ID
    @PutMapping("/id/{id}")
    public Employee updateEmployeeById(@PathVariable Long id, @RequestBody Employee employee) {
        return employeeEntry.put(id, employee);
    }
}