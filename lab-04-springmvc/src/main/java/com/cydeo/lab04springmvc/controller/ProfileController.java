package com.cydeo.lab04springmvc.controller;


import com.cydeo.lab04springmvc.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
public class ProfileController {

    @RequestMapping("/profile")
    public String getProfil(Model model){
        Profile profile = new Profile("msmith@gmaiil.com","+12567894345","mike",
                "smith","msmith", LocalDateTime.of(2022,9,21,1,59,54,246672));

        model.addAttribute("profile",profile);


        return "profile/profile-info";
    }

}
