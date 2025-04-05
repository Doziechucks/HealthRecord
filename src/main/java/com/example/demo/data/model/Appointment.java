package com.example.demo.data.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optional, but recommended
    private Long id;

    private String appointmentId;
    private LocalDate dateAndTime;
    private String DoctorName;
    @ManyToOne
    @JoinColumn(name = "patient_id")  // Foreign key for the patient
    private Patients patient;
}
