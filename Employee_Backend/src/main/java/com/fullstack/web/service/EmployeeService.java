package com.fullstack.web.service;

import com.fullstack.web.model.Employee;
import com.fullstack.web.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Optional<Employee> getEmployee(Long codeEmployee) {
        try {
            Optional<Employee> employee = employeeRepo.findById(codeEmployee);
            return employee;
        }catch (Exception e){
            return null;
        }
    }

    public Employee addEmployee(Employee employee) {
        return employeeRepo.save(employee);
    }
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public boolean deleteEmployee(String codeEmployee) {
        try {
            employeeRepo.delete(employeeRepo.getOne(Long.valueOf(codeEmployee)));
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean updateEmployee(Employee employee) {
        try {
            employeeRepo.saveAndFlush(employee);
        }catch (Exception e){
            return false;
        }
        return true;
    }
}
