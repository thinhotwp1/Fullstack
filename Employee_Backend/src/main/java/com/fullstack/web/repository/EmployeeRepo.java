package com.fullstack.web.repository;

import com.fullstack.web.model.Employee;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {

    @Override
    Optional<Employee> findById(Long aLong);

    List<Employee> findAllByNameOrEmailOrderByName(String name, String email);

    @Override
    List<Employee> findAll();

    @Override
    List<Employee> findAll(Sort sort);
}
