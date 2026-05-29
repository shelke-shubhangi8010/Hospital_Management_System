package com.hospital.Hospital_Management_System.Entity;



import jakarta.persistence.*;

@Entity
@Table(name="billing")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patientName;
    private double treatmentCost;
    private double medicineCost;
    private double totalAmount;

    public Billing() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(
            String patientName) {
        this.patientName = patientName;
    }

    public double getTreatmentCost() {
        return treatmentCost;
    }

    public void setTreatmentCost(
            double treatmentCost) {
        this.treatmentCost = treatmentCost;
    }

    public double getMedicineCost() {
        return medicineCost;
    }

    public void setMedicineCost(
            double medicineCost) {
        this.medicineCost = medicineCost;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(
            double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
