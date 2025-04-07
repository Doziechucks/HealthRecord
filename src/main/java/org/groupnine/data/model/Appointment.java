package org.groupnine.data.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class Appointment {
    private String appointmentId;
    private LocalDate dateAndTime;
    private String patientName;
    private String doctorName;
    private String patientId;
    private String doctorId;
    private String appointmentPurpose;



}

