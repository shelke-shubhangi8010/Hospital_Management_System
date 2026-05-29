package com.hospital.Hospital_Management_System.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hospital.Hospital_Management_System.Service.AppointmentService;
import com.hospital.Hospital_Management_System.Service.DoctorService;
import com.hospital.Hospital_Management_System.Service.PatientService;

@Controller
public class HomeController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @Autowired
    private AppointmentService appointmentService;

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String adminPage(Model model) {

        model.addAttribute(
                "patientCount",
                patientService.getPatientCount());

        model.addAttribute(
                "doctorCount",
                doctorService.getDoctorCount());

        model.addAttribute(
                "appointmentCount",
                appointmentService.getAppointmentCount());

        return "admin";
    }
    
   
}