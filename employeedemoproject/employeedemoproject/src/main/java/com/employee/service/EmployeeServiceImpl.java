package com.employee.service;

import com.employee.entity.Employee;
import com.employee.exception.EmployeeNotFoundException;
import com.employee.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{


    @Autowired
    private EmployeeRepository employeeRepository;

    Logger logger=org.slf4j.LoggerFactory.getLogger(EmployeeServiceImpl.class);



    @Override
    public Employee saveEmployee(Employee employee) {
            return employeeRepository.save(employee);
        }


    @Override
    public Employee getEmployeeById(int employeeId) {
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        logger.warn("get employee by Id");
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee Not Found" + employeeId);
        }
        Employee employee1 = employee.get();
        return employee1;
    }



    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> allEmployees=employeeRepository.findAll();
        return allEmployees;
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        Optional<Employee> newEmployee=employeeRepository.findById(employee.getEmployeeId());
        if(newEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found with id:"+employee.getEmployeeId());
        }
        Employee updatedEmployee= employeeRepository.save(employee);
        return updatedEmployee;
    }

    @Override
    public void deleteEmployee(int employeeId) {
        Optional<Employee> newEmployee=employeeRepository.findById(employeeId);
        if(newEmployee.isEmpty()){
            throw new EmployeeNotFoundException("Employee Not Found with id:"+employeeId);
        }
        employeeRepository.deleteById(employeeId);
    }
}
