package com.hospital.Hospital_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.Patient;
import com.hospital.Hospital_Management_System.Service.PatientService;

@Controller
@RequestMapping("/patients")
public class PatientController {

    @Autowired
    private PatientService service;

    @GetMapping("/history")
    public String patientHistory(Model model) {

        model.addAttribute(
                "patients",
                service.getAllPatients());

        return "patientHistory";
    }
    @GetMapping("/patient")
    public String patientDashboard() {
        return "patient-dashboard";
    }
}