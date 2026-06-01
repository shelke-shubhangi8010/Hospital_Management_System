package com.hospital.Hospital_Management_System.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.hospital.Hospital_Management_System.Entity.Appointment;
import com.hospital.Hospital_Management_System.Service.AppointmentService;

@Controller
@RequestMapping("/appointments")
public class AppointmentController {

    @Autowired
    private AppointmentService service;

    @GetMapping("/viewAppointments")
    public String viewAppointments(Model model) {

        model.addAttribute(
            "appointments",
            service.getAllAppointments());

        return "appointments";
    }

    @GetMapping("/addAppointment")
    public String addAppointmentPage() {
        return "addAppointment";
    }

    @PostMapping("/saveAppointment")
    public String saveAppointment(Appointment a) {

        service.saveAppointment(a);

        return "redirect:/appointments/viewAppointments";
    }

    @GetMapping("/editAppointment/{id}")
    public String editAppointment(
            @PathVariable Long id,
            Model model) {

        model.addAttribute(
            "appointment",
            service.getAppointmentById(id));

        return "editAppointment";
    }

    @PostMapping("/updateAppointment")
    public String updateAppointment(Appointment a) {

        System.out.println("ID = " + a.getId());

        service.saveAppointment(a);

        return "redirect:/appointments/viewAppointments";
    }

    @GetMapping("/deleteAppointment/{id}")
    public String deleteAppointment(
            @PathVariable Long id) {

        service.deleteAppointment(id);

        return "redirect:/appointments/viewAppointments";
    }
}