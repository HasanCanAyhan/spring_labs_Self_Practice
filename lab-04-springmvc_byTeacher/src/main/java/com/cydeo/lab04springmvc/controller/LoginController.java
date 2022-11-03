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

        //http://localhost:8080/login/email@email.com/1234124241


        model.addAttribute("email",mail);
        model.addAttribute("phoneNumber",phoneNumber);
        model.addAttribute("loginMessage","Login Successful");

        return "login/login-info.html";
    }

}
