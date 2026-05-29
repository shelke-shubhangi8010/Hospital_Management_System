package com.hospital.Hospital_Management_System.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.User;
import com.hospital.Hospital_Management_System.Service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    @PostMapping("/saveUser")
    public String saveUser(User user) {

        service.saveUser(user);

        return "redirect:/";
    }
}
