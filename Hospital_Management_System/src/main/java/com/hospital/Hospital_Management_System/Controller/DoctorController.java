/*package com.hospital.Hospital_Management_System.Controller;



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
   
}*/
package com.hospital.Hospital_Management_System.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hospital.Hospital_Management_System.Entity.LabReport;
import com.hospital.Hospital_Management_System.Entity.Schedule;
import com.hospital.Hospital_Management_System.Service.LabReportService;
import com.hospital.Hospital_Management_System.Service.ScheduleService;

@Controller
public class DoctorController {

    @GetMapping("/doctor")
    public String doctorDashboard() {
        return "doctor-dashboard";
    }
    
    @GetMapping("/manageAvailability")
    public String manageAvailability()
    {
        return "manageAvailability";
    }
    
    @PostMapping("/saveAvailability")
    public String saveAvailability(
    @RequestParam String doctorName,
    @RequestParam String availableDay,
    @RequestParam String availableTime,
    @RequestParam String status)
    {
        return "redirect:/manageAvailability";
    }
    
    @GetMapping("/schedule")
    public String schedulePage()
    {
        return "schedule";
    }
    
    @Autowired
    ScheduleService scheduleService;

   
    @PostMapping("/saveSchedule")
    public String saveSchedule(
            @RequestParam String doctorName,
            @RequestParam String specialization,
            @RequestParam String day,
            @RequestParam String time,
            @RequestParam String status,
            @RequestParam String consultationType,
            @RequestParam int fees)
    {

        Schedule s = new Schedule();

        s.setDoctorName(doctorName);
        s.setSpecialization(specialization);
        s.setDay(day);
        s.setTime(time);
        s.setStatus(status);
        s.setConsultationType(consultationType);
        s.setFees(fees);

        scheduleService.saveSchedule(s);

        return "redirect:/schedule";
    }

    @Autowired
    LabReportService labReportService;

   

    @PostMapping("/saveReport")
    public String saveReport(
    @RequestParam String patientName,
    @RequestParam String testName,
    @RequestParam String reportResult,
    @RequestParam String reportDate)
    {
        LabReport report = new LabReport();

        report.setPatientName(patientName);
        report.setTestName(testName);
        report.setReportResult(reportResult);
        report.setReportDate(reportDate);

        LabReport.saveReport(report);

        return "redirect:/labreport";
    }
   
}
