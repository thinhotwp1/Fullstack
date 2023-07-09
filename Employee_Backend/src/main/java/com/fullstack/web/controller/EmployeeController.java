package com.fullstack.web.controller;

import com.fullstack.web.model.Employee;
import com.fullstack.web.model.FindEmployeeByNameOrEmail;
import com.fullstack.web.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    @GetMapping("/get-Employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }


    @GetMapping("/find-Employee-by-id")
    public Optional<Employee> getEmployee(@RequestParam Long codeEmployee){
        return employeeService.getEmployee(codeEmployee);
    }

    @PostMapping("/find-Employee-by-name-or-email")
    public ResponseEntity<List<Employee>> addEmployee(@RequestBody FindEmployeeByNameOrEmail request){
        try {
            return new ResponseEntity<>(employeeService.findEmployee(request),HttpStatus.OK);
        } catch (Exception e) {
            System.out.println("Error find employee by name or email: "+ e);
        }
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-Employee")
    public ResponseEntity<Integer> addEmployee(@RequestBody List<Employee> employees){
        return new ResponseEntity<>(employeeService.addEmployee(employees),HttpStatus.OK);
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
