package com.example;

import com.example.mock.EmployeeRepository_Stub;
import com.example.mock.bankService_stub;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.when;

class EmployeeManagerTest {
    private static EmployeeRepository employeeRepository_stub;
    private static BankService bankService;

    @BeforeAll
    static void setup() {
        employeeRepository_stub = new EmployeeRepository_Stub();
        bankService = new bankService_stub();
    }

    @Test
    void paymentsShouldReturn4TransactionsFromStub() {
        var epm = new EmployeeManager(employeeRepository_stub, bankService);
        assertThat(epm.payEmployees()).isEqualTo(4);
    }
    @Test
    void paymentShouldReturn4TransactionsFromMockitoDoubles(){
        EmployeeRepository employeeRepository = Mockito.mock(EmployeeRepository.class);
        BankService bankService = Mockito.mock(BankService.class);

        when(employeeRepository.findAll()).thenReturn(List.of(
                new Employee("Joel", 2500.00),
                new Employee("Kris", 2500.00),
                new Employee("Adam", 2500.00),
                new Employee("PoPo", 2500.00)
        ));

        EmployeeManager eManager = new EmployeeManager(employeeRepository, bankService);

        assertThat(eManager.payEmployees()).isEqualTo(4);
    }
}