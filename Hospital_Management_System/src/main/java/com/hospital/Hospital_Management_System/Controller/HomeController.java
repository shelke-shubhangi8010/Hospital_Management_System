package com.hospital.Hospital_Management_System.Controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }
    @GetMapping("/admin")
    public String adminPage() {
        return "admin";
    }
    
    @GetMapping("/patients")
    public String patientsPage() {
        return "patients";
    }
}