package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeTest {

    @Test
    void createEmployeeShouldPrintMatchingIdAndSalary() {
        String id = "Martha";
        double salary = 39_500.00;
        Employee employee = new Employee(id, salary);

        String expected = "Employee [id=" + id + ", salary=" + salary + "]";

        assertThat(employee.toString()).isEqualTo(expected);
    }
}
