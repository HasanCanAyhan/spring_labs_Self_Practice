package com.cydeo.lab04springmvc.controller;

import com.cydeo.lab04springmvc.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

    @RequestMapping("/login/{mail}/{phoneNumber}")
    public String getLogin(@PathVariable String mail, @PathVariable String phoneNumber, Model model){

        Login login = new Login(mail,phoneNumber,"Login Successful");

        model.addAttribute("email",login.getEmail());
        model.addAttribute("phoneNumber",login.getPhoneNumber());
        model.addAttribute("loginMessage",login.getPassword());

        return "login/login-info.html";
    }

}
