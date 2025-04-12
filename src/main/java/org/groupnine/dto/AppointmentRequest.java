package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
public class AppointmentRequest {
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;
    private String appointmentPurpose;
    private String appointmentDate;
    private String patientId;
    private String DoctorId;

    public AppointmentRequest(String appointmentPurpose, String appointmentDate, String patientId, String DoctorId) {

        this.appointmentPurpose = appointmentPurpose;
        this.appointmentDate = appointmentDate;
        this.patientId = patientId;
        this.DoctorId = DoctorId;
    }
}
