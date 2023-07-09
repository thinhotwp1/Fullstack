package com.fullstack.web.model;

import lombok.Data;

@Data
public class FindEmployeeByNameOrEmail {
    private String name;
    private String email;

}
