package com.example;

import com.example.mock.EmployeeRepository_Stub;
import com.example.mock.bankService_stub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {
    private static EmployeeRepository employeeRepository_stub;
    private static BankService bankService;
    private static EmployeeRepository employeeRepository_mock;
    private static BankService bankService_mock = Mockito.mock(BankService.class);

    @BeforeAll
    static void setup() {
        employeeRepository_stub = new EmployeeRepository_Stub();
        bankService = new bankService_stub();
        employeeRepository_mock = Mockito.mock(EmployeeRepository.class);
        bankService_mock = Mockito.mock(BankService.class);
        populateRepositoryMock();
    }

    private static void populateRepositoryMock() {
        when(employeeRepository_mock.findAll()).thenReturn(
                List.of(
                        new Employee("Joel", 2500.00),
                        new Employee("Kris", 2500.00),
                        new Employee("Adam", 2500.00),
                        new Employee("PoPo", 2500.00)
                ));
    }

    @Test
    void paymentsShouldReturn4TransactionsFromStub() {
        var eManager = new EmployeeManager(employeeRepository_stub, bankService);
        assertThat(eManager.payEmployees()).isEqualTo(4);
    }

    @Test
    void paymentShouldReturn4TransactionsFromMockitoDoubles() {


        EmployeeManager eManager = new EmployeeManager(employeeRepository_mock, bankService_mock);

        assertThat(eManager.payEmployees()).isEqualTo(4);
    }

    @Test
    void makePaymentWithoutBankServiceShouldNotMakePayments() {
        EmployeeManager eManager = new EmployeeManager(employeeRepository_mock, null);

        employeeRepository_mock.findAll().forEach((e) -> assertFalse(e.isPaid()));
        assertThat(eManager.payEmployees()).isEqualTo(0);

    }
}