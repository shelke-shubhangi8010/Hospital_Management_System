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

    // Login Page
    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    // Register Page
    @GetMapping("/register")
    public String registerPage() {
        return "register";
    }

    // Save User
    @PostMapping("/saveUser")
    public String saveUser(User user) {
        service.saveUser(user);
        return "redirect:/";
    }

    // Login Logic
    @PostMapping("/login")
    public String loginUser(@RequestParam String username,
                            @RequestParam String password) {

        User user = service.login(username, password);
        System.out.println("Role = " + user.getRole());

        if(user != null) {

            if(user.getRole().equalsIgnoreCase("ADMIN")) {
                return "redirect:/admin";
            }
            else if(user.getRole().equalsIgnoreCase("DOCTOR")) {
                return "redirect:/doctor";
            }
            else if(user.getRole().equalsIgnoreCase("PATIENT")) {
                return "redirect:/patient";
            }
        }

        return "redirect:/?error";
    }
}
