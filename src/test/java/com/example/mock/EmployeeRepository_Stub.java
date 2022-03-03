package com.example.mock;

import com.example.Employee;
import com.example.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository_Stub implements EmployeeRepository {
    List<Employee> employees;

    public EmployeeRepository_Stub(List<Employee> employees) {
        this.employees = employees;
    }

    public EmployeeRepository_Stub() {
        this.employees = List.of(
                new Employee("Joel", 2500.00),
                new Employee("Kris", 2500.00),
                new Employee("Adam", 2500.00),
                new Employee("PoPo", 2500.00)
        );
    }

    @Override
    public List<Employee> findAll() {
        return employees;
    }

    @Override
    public Employee save(Employee e) {
        employees.add(e);
        return e;
    }
}
