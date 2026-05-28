package com.hospital.Hospital_Management_System.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.Patient;
import com.hospital.Hospital_Management_System.Service.PatientService;

@Controller
@RequestMapping("/Patient")
public class PatientController {

    @Autowired
    private PatientService service;

    @PostMapping
    public Patient addPatient(@RequestBody Patient p) {
        return service.savePatient(p);
    }

    @GetMapping
    public List<Patient> getPatients() {
        return service.getAllPatients();
    }
    
    @PutMapping("/{id}")
    public Patient updatePatient(
            @PathVariable Long id,
            @RequestBody Patient p) {

        return service.updatePatient(id, p);
    }
    
    @DeleteMapping("/{id}")
    public String deletePatient(
            @PathVariable Long id) {

        service.deletePatient(id);
        return "Patient Deleted Successfully";
}
    
    @GetMapping("/viewPatients")
    public String viewPatients(Model model) {

        model.addAttribute(
                "patients",
                service.getAllPatients());

        return "patient";
    }
    
    @GetMapping("/addPatient")
    public String addPatientPage() {
        return "addPatient";
    }
    
    @PostMapping("/savePatient")
    public String savePatientForm(Patient p) {

        service.savePatient(p);

        
        return "redirect:/patients/viewPatients";
    }
    
}