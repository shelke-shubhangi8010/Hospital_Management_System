package com.hospital.Hospital_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.User;
import com.hospital.Hospital_Management_System.Service.UserService;

@Controller
public class AuthController {

    @Autowired
    private UserService service;

    // Home Page
    @GetMapping("/")
    public String homePage() {
        return "home";
    }

    // Role Login Page
    @GetMapping("/login/{role}")
    public String roleLogin(
            @PathVariable String role,
            Model model) {

        model.addAttribute("role", role);
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
    public String loginUser(
            @RequestParam String username,
            @RequestParam String password,
            @RequestParam String role) {

        User user = service.login(username, password);

        if(user != null &&
           user.getRole().equalsIgnoreCase(role)) {

             if(role.equalsIgnoreCase("DOCTOR")) {
                return "redirect:/doctor";
            }
            else {
                return "redirect:/patient";
            }
        }

        return "redirect:/?error";
    }
}