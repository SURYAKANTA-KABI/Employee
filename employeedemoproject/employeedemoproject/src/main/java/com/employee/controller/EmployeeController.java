package com.employee.controller;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/save")
    public ResponseEntity<Employee> addFlight(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.saveEmployee(employee);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>(newEmployee, HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/get/{eId}")
    public ResponseEntity<Object> fetchEmployeeById(@PathVariable("eId") int employeeId) {
        Employee employee = employeeService.getEmployeeById(employeeId);
        ResponseEntity<Object> responseEntity = new ResponseEntity<>(employee,HttpStatus.OK);
        return responseEntity;
    }

    @GetMapping("/getall")
    public List<Employee> fetchAllEmployees(){
        List<Employee> employeeList = employeeService.getAllEmployees();
        return employeeList;

    }

    @PutMapping("/update")
    public ResponseEntity<Employee> modifyUser(@RequestBody Employee employee) {
        Employee updateUser = employeeService.updateEmployee(employee);
        ResponseEntity<Employee> responseEntity = new ResponseEntity<>(updateUser, HttpStatus.OK);
        return responseEntity;
    }

    @DeleteMapping("/delete/{employeeId}")
    public ResponseEntity<String> removeUser(@PathVariable("employeeId") int employeeId) {
        employeeService.deleteEmployee(employeeId);
        ResponseEntity<String> responseEntity = new ResponseEntity<>("Employee deleted successfully!!", HttpStatus.OK);
        return responseEntity;
    }




}
