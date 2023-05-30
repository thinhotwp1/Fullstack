package com.fullstack.web.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false,updatable = false)
    private Long employeeCode;
    private String name;
    private String email;
    private String jobTitle;
    private String phone;
    private String imageUrl;

    public Employee() {
    }

    public Employee( String name, String email, String jobTitle, String phone, String imageUrl, Long employeeCode) {
        this.name = name;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phone = phone;
        this.imageUrl = imageUrl;
        this.employeeCode = employeeCode;
    }
}
