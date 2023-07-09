package com.fullstack.web.service;

import com.fullstack.web.model.Employee;
import com.fullstack.web.model.FindEmployeeByNameOrEmail;
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

    public int addEmployee(List<Employee> employees) {
        int i=0;
        for (Employee employee:employees){
            try {
                employeeRepo.save(employee);
                i++;
            }catch (Exception e){
                System.out.println("Lỗi khi thêm nhân viên: "+e);
            }
        }
        return i;
    }
    public List<Employee> getEmployees() {
        return employeeRepo.findAll();
    }

    public List<Employee> findEmployee(FindEmployeeByNameOrEmail request) throws Exception{
        return employeeRepo.findAllByNameOrEmailOrderByName(request.getName(), request.getEmail());
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
