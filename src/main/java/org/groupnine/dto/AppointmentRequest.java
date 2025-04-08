package org.groupnine.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AppointmentRequest {
    String appointmentId;
    String appointmentPurpose;
    String appointmentDate;
    String patientId;
    String DoctorId;

    public AppointmentRequest(String appointmentId, String appointmentPurpose, String appointmentDate, String patientId, String DoctorId) {
        this.appointmentId = appointmentId;
        this.appointmentPurpose = appointmentPurpose;
        this.appointmentDate = appointmentDate;
        this.patientId = patientId;
        this.DoctorId = DoctorId;
    }

}
