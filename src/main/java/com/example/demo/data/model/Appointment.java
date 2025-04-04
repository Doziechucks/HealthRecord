package com.example.demo.data.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
public class Appointment {
    private String appointmentId;
    private LocalDate dateAndTime;
    private String DoctorName;
    private String PatientName;
}
