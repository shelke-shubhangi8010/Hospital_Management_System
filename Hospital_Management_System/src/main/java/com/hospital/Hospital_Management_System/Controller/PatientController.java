/*package com.hospital.Hospital_Management_System.Controller;

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
}*/




    
    package com.hospital.Hospital_Management_System.Controller;

    import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.Hospital_Management_System.Entity.Appointment;
import com.hospital.Hospital_Management_System.Entity.Doctor;
import com.hospital.Hospital_Management_System.Entity.Patient;
import com.hospital.Hospital_Management_System.Repository.AppointmentRepository;
import com.hospital.Hospital_Management_System.Service.AppointmentService;
import com.hospital.Hospital_Management_System.Service.DoctorService;
import com.hospital.Hospital_Management_System.Service.LabReportService;
import com.hospital.Hospital_Management_System.Service.PatientService;
import com.hospital.Hospital_Management_System.Service.ScheduleService;

    @Controller
    public class PatientController {
    	 @Autowired
    	    DoctorService doctorService;

        @GetMapping("/patient")
        public String patientDashboard() {
            return "patient-dashboard";
        }

        @GetMapping("/appointment")
        public String appointmentPage() {
            return "appointment";
        }
     /*
        @GetMapping("/prescription")
        public String prescriptionPage() {
            return "prescription";
        }*/
        @Autowired
        AppointmentService appointmentservice;

        @Autowired
        ScheduleService scheduleService;

        @Autowired
        LabReportService  labreportservice;
        @GetMapping("/doctorAvailability")
        public String doctorAvailability(Model model)
        {
            model.addAttribute(
                "doctorList",
                scheduleService.getAllSchedules()
            );

            return "doctorAvailability";
        }

        @GetMapping("/billing")
        public String billingPage() {
            return "billing";
        }

        @GetMapping("/labreport")
        public String labReportPage(Model model) {

            model.addAttribute(
                "patientList",
                patientService.getAllPatients()
            );

            return "labreport";
        }

        @GetMapping("/logout")
        public String logout() {
            return "redirect:/";
        }
        
        @GetMapping("/medicalReport")
        public String medicalReport(Model model)
        {
            model.addAttribute(
                "reportList",
                labreportservice.getAllReports()
            );

            return "medicalReport";
        }
        
        @Autowired
        PatientService patientService;
        @GetMapping("/patientHistory")
        public String patientHistory(Model model)
        {
            List<Patient> patientList = patientService.getAllPatients();

            model.addAttribute("patientList", patientList);

            return "patientHistory";
        }
        
        @GetMapping("/patient/add")
        public String showAddPatientForm(Model model) {
            model.addAttribute("patient", new Patient());
            return "addPatient";
        }
        
        @PostMapping("/patient/save")
        public String savePatient(@ModelAttribute Patient patient) {

            AppointmentRepository.saveAll(patient);

            return "redirect:/patientHistory";
        }
    }
