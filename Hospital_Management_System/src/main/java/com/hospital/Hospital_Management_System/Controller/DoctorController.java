package com.hospital.Hospital_Management_System.Controller;



import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.Doctor;
import com.hospital.Hospital_Management_System.Service.DoctorService;

@Controller
public class DoctorController {

    @Autowired
    private DoctorService service;
    
    @GetMapping("/viewDoctors")
    public String viewDoctors(Model model) {

        ((Model) model).addAttribute(
            "doctors",
            service.getAllDoctors());

        return "doctors";
    }
    
    @GetMapping("/addDoctor")
    public String addDoctorPage() {
        return "addDoctor";
    }
    
    @PostMapping("/saveDoctor")
    public String saveDoctor(
            Doctor d) {

        service.saveDoctor(d);

        return "redirect:/viewDoctors";
    }
    
    @GetMapping("/editDoctor/{id}")
    public String editDoctor(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
            "doctor",
            service.getDoctorById(id));

        return "editDoctor";
    }
    
    @PostMapping("/updateDoctor")
    public String updateDoctor(
            Doctor d) {

        service.saveDoctor(d);

        return "redirect:/viewDoctors";
    }
    
    @GetMapping("/deleteDoctor/{id}")
    public String deleteDoctor(
            @PathVariable Long id) {

        service.deleteDoctor(id);

        return "redirect:/viewDoctors";
    }
    @GetMapping("/doctor")
    public String doctorDashboard() {
        return "doctor-dashboard";
    }
}

