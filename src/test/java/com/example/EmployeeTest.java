package com.example;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class EmployeeTest {

    @Test
    void createEmployeeShouldPrintMatchingIdAndSalaryTroughToString() {
        String id = "Martha";
        double salary = 39_500.00;
        Employee employee = new Employee(id, salary);

        String expected = "Employee [id=" + id + ", salary=" + salary + "]";

        assertThat(employee.toString()).isEqualTo(expected);
    }

    @Test
    void valuesSetThroughSetMethodShouldGetSaidValue(){
        Employee employee = new Employee("", 0.0);

        String id = "Martha";
        double salary = 39_500.00;
        boolean isPaid = false;

        employee.setId(id);
        assertThat(employee.getId()).isEqualTo(id);

        employee.setSalary(salary);
        assertThat(employee.getSalary()).isEqualTo(salary);

        employee.setPaid(isPaid);
        assertThat(employee.isPaid()).isEqualTo(isPaid);

    }
}
