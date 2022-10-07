package com.employee.repository;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.service.EmployeeService;
import com.employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@SpringBootTest
public class FlightRespositoryTest {

    @InjectMocks
    private EmployeeService employeeService = new EmployeeServiceImpl();

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    void testSaveEmployee() {
        Employee employee=new Employee();
        employee.setEmployeeId(1);
        employee.setEmployeeName("surya");
        employee.setSalary(28000.00);
        employee.setMobileNumber(824960955);
        employee.setEmailId("surya@gmail.com");
        employee.setAddress("odisha");

        when(employeeRepository.save(employee)).thenReturn(employee);
        assertEquals(employee,employeeRepository.save(employee));
    }

    @Test
    void testDeleteBooking() {

        Employee employee=new Employee();
        employee.setEmployeeId(1);
        employee.setEmployeeName("surya");
        employee.setSalary(28000.00);
        employee.setMobileNumber(824960955);
        employee.setEmailId("surya@gmail.com");
        employee.setAddress("odisha");

        Optional<Employee> optionalEmployee= Optional.of(employee);
        when(employeeRepository.findById(1)).thenReturn(optionalEmployee);
        employeeService.deleteEmployee(1);

    }
    @Test
    void testDeleteBookingByIdWithException() {

        when(employeeRepository.findById(1)).thenThrow(EmployeeNotFoundException.class);
        assertThrows(EmployeeNotFoundException.class, () -> employeeService.deleteEmployee(1));
    }

}

