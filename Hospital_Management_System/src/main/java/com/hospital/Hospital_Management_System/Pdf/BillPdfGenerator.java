package com.hospital.Hospital_Management_System.Pdf;



import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

import com.hospital.Hospital_Management_System.Entity.Billing;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfWriter;

public class BillPdfGenerator {

    public static ByteArrayInputStream generateBill(
            Billing bill) {

        Document document =
                new Document();

        ByteArrayOutputStream out =
                new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(
                    document,
                    out);

            document.open();

            Font font =
                    FontFactory.getFont(
                            FontFactory.HELVETICA_BOLD,
                            18);

            Paragraph title =
                    new Paragraph(
                            "Hospital Bill",
                            font);

            title.setAlignment(
                    Element.ALIGN_CENTER);

            document.add(title);

            document.add(
                    new Paragraph(" "));

            document.add(
                    new Paragraph(
                            "Patient: "
                            + bill.getPatientName()));

            document.add(
                    new Paragraph(
                            "Treatment Cost: "
                            + bill.getTreatmentCost()));

            document.add(
                    new Paragraph(
                            "Medicine Cost: "
                            + bill.getMedicineCost()));

            document.add(
                    new Paragraph(
                            "Total Amount: "
                            + bill.getTotalAmount()));

            document.close();

        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(
                out.toByteArray());
    }
}