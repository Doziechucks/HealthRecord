package com.example.demo.data.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Doctor extends User{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Patients> patients;
    @OneToMany
    private List<Appointment> appointments;

  public Doctor(){
      this.patients = new ArrayList<>();
      this.appointments = new ArrayList<>();
  }
}
