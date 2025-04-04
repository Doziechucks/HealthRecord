package com.example.demo.data.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Patients extends User{
    private String medicalHistory;
    private List<Appointment> appointments;
}
