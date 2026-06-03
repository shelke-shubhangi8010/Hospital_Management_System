package com.hospital.Hospital_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hospital.Hospital_Management_System.Entity.Prescription;
import com.hospital.Hospital_Management_System.Service.PrescriptionService;

@Controller
@RequestMapping("/prescription")
public class PrescriptionController {

    @Autowired
    private PrescriptionService service;

    // doctor page
    @GetMapping("/manage")
    public String managePrescription() {
        return "manage-prescription";
    }

    // save
    @PostMapping("/save")
    public String savePrescription(
            Prescription p){

        service.savePrescription(p);

        return "redirect:/doctor";
    }

    // patient view
    @GetMapping
    public String prescriptionPage(
            Model model){

        model.addAttribute(
                "prescriptions",
                service.getAllPrescription());

        return "prescription";
    }
}
