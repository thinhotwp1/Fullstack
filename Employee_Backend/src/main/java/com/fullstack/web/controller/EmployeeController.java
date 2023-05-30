package com.fullstack.web.controller;

import com.fullstack.web.model.Employee;
import com.fullstack.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/get-Employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/find-Employee")
    public Optional<Employee> getEmployee(@RequestParam Long codeEmployee){
        return employeeService.getEmployee(codeEmployee);
    }

    @PostMapping("/add-Employee")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.addEmployee(employee),HttpStatus.OK);
    }

    @PostMapping("/delete-Employee")
    public boolean deleteEmployee(@RequestParam String codeEmployee){
        return employeeService.deleteEmployee(codeEmployee);
    }

    @PostMapping("/update-Employee")
    public boolean updateEmployee(@RequestBody Employee employee){
        return employeeService.updateEmployee(employee);
    }

}
