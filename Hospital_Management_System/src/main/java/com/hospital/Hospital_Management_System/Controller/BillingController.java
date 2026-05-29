package com.hospital.Hospital_Management_System.Controller;

import java.io.ByteArrayInputStream;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.core.io.InputStreamResource;

import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.hospital.Hospital_Management_System.Entity.Billing;
import com.hospital.Hospital_Management_System.Pdf.BillPdfGenerator;
import com.hospital.Hospital_Management_System.Service.BillingService;

    @Controller
    public class BillingController {

        @Autowired
        private BillingService service;

        @GetMapping("/viewBills")
        public String viewBills(
                Model model) {

            model.addAttribute(
                "bills",
                service.getAllBills());

            return "billing";
        }
        
        @GetMapping("/addBill")
        public String addBillPage() {
            return "addBill";
        }
        
        @PostMapping("/saveBill")
        public String saveBill(
                Billing b) {

            service.saveBill(b);

            return "redirect:/viewBills";
        }
        
        @GetMapping("/editBill/{id}")
        public String editBill(
                @PathVariable Long id,
                Model model) {

            model.addAttribute(
                "bill",
                service.getBillById(id));

            return "editBill";
        }
        
        @PostMapping("/updateBill")
        public String updateBill(
                Billing b) {

            service.saveBill(b);

            return "redirect:/viewBills";
        }
        
        @GetMapping("/deleteBill/{id}")
        public String deleteBill(
                @PathVariable Long id) {

            service.deleteBill(id);

            return "redirect:/viewBills";
        }
        
        @GetMapping("/downloadBill/{id}")
        public ResponseEntity<InputStreamResource>
        downloadBill(
                @PathVariable Long id) {

            Billing bill =
                    service.getBillById(id);

            ByteArrayInputStream pdf =
                    BillPdfGenerator
                    .generateBill(bill);

            HttpHeaders headers =
                    new HttpHeaders();

            headers.add(
                    "Content-Disposition",
                    "inline; filename=bill.pdf");

            return ResponseEntity
                    .ok()
                    .headers(headers)
                    .contentType(
                            MediaType.APPLICATION_PDF)
                    .body(
                            new InputStreamResource(
                                    pdf));
        }
    }

