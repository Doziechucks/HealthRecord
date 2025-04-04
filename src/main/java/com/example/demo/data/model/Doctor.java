package com.example.demo.data.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Doctor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Optional, but recommended
    private Long id;

    private List<Patients> patients;
    private List<Appointment> appointments;

  public Doctor(){
      this.patients = new ArrayList<>();
      this.appointments = new ArrayList<>();
  }
}
