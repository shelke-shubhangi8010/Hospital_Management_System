package com.hospital.Hospital_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.Patient;
import com.hospital.Hospital_Management_System.Service.PatientService;

@Controller
//@RequestMapping("/Patients")
public class PatientController {

    @Autowired
    private PatientService service;

    // View all patients
    @GetMapping("/viewPatients")
    public String viewPatients(Model model) {

        model.addAttribute(
                "patients",
                service.getAllPatients());

        return "patient";
    }

    // Open Add Patient page
    @GetMapping("/addPatient")
    public String addPatientPage(Model model) {

        model.addAttribute(
                "patient",
                new Patient());

        return "addPatient";
    }
    // Save patient
    @PostMapping("/savePatient")
    public String savePatientForm(Patient p) {

        service.savePatient(p);

        return "redirect:/viewPatients";
    }

    // Edit patient page
    @GetMapping("/editPatient/{id}")
    public String editPatient(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
                "patient",
                service.getPatientById(id));

        return "editPatient";
    }

    // Update patient
    @PostMapping("/updatePatient")
    public String updatePatientForm(
            Patient p) {

        service.savePatient(p);

        return "redirect:/patients/viewPatients";
    }

    // Delete patient
    @GetMapping("/deletePatient/{id}")
    public String deletePatient(
            @PathVariable Long id) {

        service.deletePatient(id);

        return "redirect:/patients/viewPatients";
    }
}