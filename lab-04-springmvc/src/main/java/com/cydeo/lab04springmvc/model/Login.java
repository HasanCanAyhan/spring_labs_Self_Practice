package com.cydeo.lab04springmvc.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Login {
    private String email;
    private String phoneNumber;
    private String password;
}
