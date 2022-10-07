package com.employee.service;

import com.employee.entity.Employee;

import java.util.List;
//@FunctionalInterface
public interface EmployeeService{
    Employee saveEmployee(Employee employee);
    Employee getEmployeeById(int employeeId);
    List<Employee> getAllEmployees();
    Employee updateEmployee(Employee employee);
    void deleteEmployee(int employeeId);



}
